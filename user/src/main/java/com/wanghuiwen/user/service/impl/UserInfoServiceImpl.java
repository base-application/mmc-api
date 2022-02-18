package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.address.model.AddressCountries;
import com.wanghuiwen.address.service.AddressCountriesService;
import com.wanghuiwen.base.config.ProjectConstant;
import com.wanghuiwen.base.dao.RoleMapper;
import com.wanghuiwen.base.dao.UserMapper;
import com.wanghuiwen.base.dao.UserRoleMapper;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.base.service.RoleService;
import com.wanghuiwen.base.service.UserRoleService;
import com.wanghuiwen.common.EmailUtil;
import com.wanghuiwen.common.UtilFun;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.dao.*;
import com.wanghuiwen.user.model.*;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.security.acl.Group;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.wanghuiwen.user.config.UserResultEnum.VERIFICATION_ERROR;
import static com.wanghuiwen.user.config.UserResultEnum.VERIFICATION_INVALID;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private GradeMapper gradeMapper;
    @Resource
    private PositionMapper positionMapper;
    @Resource
    private MmcGroupMapper mmcGroupMapper;
    @Resource
    private UserCompanyMapper userCompanyMapper;
    @Resource
    private AddressCountriesService addressCountriesService;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private RoleService roleService;
    @Resource
    private NewestStoryMapper newestStoryMapper;
    @Resource
    private NotificationMapper notificationMapper;
    @Resource
    private  MmcEventMapper mmcEventMapper;
    @Resource
    private ReferralMapper referralMapper;

    @Value("${mmc.init.grade}")
    private String initGradeName;

    @Override
    public List<UserInfoVo> managerList(Integer page, Integer size, Map<String, Object> params) {
        return userInfoMapper.managerList(params);
    }

    @Override
    public void register(User user) {
        userMapper.insertSelective(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());

        Role role = roleMapper.selectByName(ProjectConstant.ROLE_USER);
        userRole.setRoleId(role.getId());

        userRoleMapper.insertSelective(userRole);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        save(userInfo);
    }

    @Override
    public List<UserNetWorkVo> network(Map<String, Object> params) {
        return userInfoMapper.network(params);
    }

    @Override
    public UserInfoVo detail(Long userId, Long id) {
        return userInfoMapper.detail(userId,id);
    }

    @Override
    public void excelToUser(List<List<String>> excelData) {
        List<UserInfo> userInfos = new ArrayList<>();
        List<String> passwords =  new ArrayList<>();
        for (List<String> excelDatum : excelData) {
            UserInfo info = new UserInfo();
            if(StringUtils.isNotEmpty(excelDatum.get(2))){
                try {
                    info.setBirthday(UtilFun.StringToDate(excelDatum.get(2),"MM/dd/YYYY").getTime());
                }catch (Exception e){
                    logger.error(excelDatum.get(1)+ "日期转换出错",e);
                }
            }
            info.setConcatNumber(excelDatum.get(3));
            info.setIndustry(excelDatum.get(5));
            info.setName(excelDatum.get(1));
            info.setEmail(excelDatum.get(4));

            if(StringUtils.isNotEmpty(excelDatum.get(8))){
                Position position = positionMapper.findByName(excelDatum.get(8));
                if(position == null){
                    position = new Position();
                    position.setPositionName(excelDatum.get(8));
                    positionMapper.insert(position);
                }
                info.setPositionId(position.getPositionId());
            }

            if(StringUtils.isNotEmpty(excelDatum.get(7))){
                MmcGroup group = mmcGroupMapper.findByName(excelDatum.get(7));
                if(group == null){
                    group = new MmcGroup();
                    group.setGroupName(excelDatum.get(7));
                    mmcGroupMapper.insert(group);
                }
                info.setGroupId(group.getGroupId());
            }


            Grade grade = gradeMapper.findByName(excelDatum.get(0));
            if(grade==null){
                grade = new Grade();
                grade.setGradeName(excelDatum.get(0));
                gradeMapper.insert(grade);
            }
            info.setGradeId(grade.getGradeId());

            String password = UtilFun.getNumRandom(8);
            passwords.add(password);
            User user = new User();
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setLoginName(info.getConcatNumber());
            user.setEnable(true);
            user.setLocked(false);
            userMapper.insert(user);

            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            Role role = roleMapper.selectByName(ProjectConstant.ROLE_USER);
            userRole.setRoleId(role.getId());

            userRoleMapper.insertSelective(userRole);


            info.setUserId(user.getId());
            save(info);

            if(StringUtils.isNotEmpty(excelDatum.get(6))){
                UserCompany company = new UserCompany();
                company.setCompanyName(excelDatum.get(6));
                company.setUserId(info.getUserId());
                userCompanyMapper.insert(company);

            }
            userInfos.add(info);
        }
        //发邮件
        for (int i = 0; i < userInfos.size(); i++) {
            try {
                EmailUtil.gmailSender(userInfos.get(i).getEmail(),"您已经注册mmc，用户名"+ userInfos.get(i).getConcatNumber() + ".密码"+passwords.get(i));
            }catch (Exception e){
                logger.error("邮件发送出错"+userInfos.get(i).getEmail(),e);
            }
        }
    }

    @Override
    public void register(String phoneNumber, String verificationCode, String password, String countryCode) {
        String key = verificationCodeKey(phoneNumber, Const.VERIFICATION_REGISTER);
        String code = redisTemplate.opsForValue().get(key);
        if(code == null){
            throw new ServiceException("验证码不可用","user.40001");
        }
        if(!verificationCode.equals(code)){
            throw new ServiceException("验证码不可用","user.40001");
        }
        password = new BCryptPasswordEncoder().encode(password);

        User user = new User();
        user.setPassword(password);
        user.setLoginName(phoneNumber);
        user.setEnable(true);
        user.setLocked(false);
        userMapper.insert(user);

        Role role = roleService.findBy("name", ProjectConstant.ROLE_USER);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        userRoleMapper.insertSelective(userRole);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        Grade grade = gradeMapper.findByName(initGradeName);
        userInfo.setGradeId(grade.getGradeId());
        AddressCountries countries = addressCountriesService.findBy("phonecode",countryCode);
        if(countries!=null){
            userInfo.setCountry(countries.getId());
        }
        userInfo.setConcatNumber(phoneNumber);
        userInfo.setMember("Member");
        save(userInfo);
        redisTemplate.delete(key);
    }


    /**
     * 验证码redis key
     * @param phoneNumber
     * @param type 1 注册 2 忘记密码
     * @return
     */
    public String verificationCodeKey(String phoneNumber, Integer type){
        return "verification:type:"+type+":"+phoneNumber;
    }

    @Override
    public UserInfoVo detail(Long userId) {
        return userInfoMapper.detailUser(userId);
    }

    @Override
    public Achievement achievements(Long id, Integer type) {
        return userInfoMapper.achievements(id,type);
    }

    @Override
    public List<User> findByGroupAndGrade(List<MmcGroup> groups, List<Grade> grades) {
        return userInfoMapper.findByGroupAndGrade(groups,grades);
    }

    @Override
    public MessageVo message(Long id) {
        int newNoRead =newestStoryMapper.notRead(id);
        int notificationNoRead = notificationMapper.noRead(id);
        int eventNoRead =  mmcEventMapper.noRead(id);
        int referNoRead =  referralMapper.noRead(id);
        MessageVo vo = new MessageVo();
        vo.setEvent(eventNoRead);
        vo.setNewset(newNoRead);
        vo.setNotification(notificationNoRead);
        vo.setCount(referNoRead+notificationNoRead+eventNoRead);
        vo.setReferral(referNoRead);
        return vo;
    }

    @Override
    public int count() {
        Condition where= new Condition(UserInfo.class);
      return userInfoMapper.selectCountByCondition(where);
    }

    @Override
    public List<ResultMap<String, Object>> groupByGrade() {
        return userInfoMapper.groupByGrade();
    }

    @Override
    public List<ResultMap<String, Object>> mapData() {
        return userInfoMapper.mapData();
    }

    @Override
    public List<MapLineVo> mapLine() {
        return userInfoMapper.mapLine();
    }
}
