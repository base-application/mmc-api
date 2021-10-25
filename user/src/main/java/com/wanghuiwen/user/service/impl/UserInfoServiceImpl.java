package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.base.config.ProjectConstant;
import com.wanghuiwen.base.dao.RoleMapper;
import com.wanghuiwen.base.dao.UserMapper;
import com.wanghuiwen.base.dao.UserRoleMapper;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.common.UtilFun;
import com.wanghuiwen.user.dao.*;
import com.wanghuiwen.user.model.*;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.acl.Group;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
        //todo 发邮件
    }
}
