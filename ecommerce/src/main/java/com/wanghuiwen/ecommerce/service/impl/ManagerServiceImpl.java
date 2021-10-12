package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.base.service.RoleService;
import com.wanghuiwen.base.service.UserRoleService;
import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import com.wanghuiwen.ecommerce.dao.ManagerMapper;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.service.ManagerService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.ecommerce.vo.ManagerVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by wanghuiwen on 2021/08/03.
 */
@Service
@Transactional
public class ManagerServiceImpl extends AbstractService<Manager> implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserService userService;
    @Resource
    private ResultGenerator resultGenerator;

    @Override
    public Result add(ManagerVo managerVo, AuthUser authUser) {
        List<Long> userRoleList = new ArrayList<>();
        User user = new User();
        user.setAvatar(managerVo.getAvatar());
        user.setLoginName(managerVo.getLoginName());
        user.setNickName(managerVo.getNickName());

        Manager manager = new Manager();
        manager.setAvatar(managerVo.getAvatar());
        manager.setName(managerVo.getNickName());
        manager.setMerchantId(managerVo.getMerchantId());
        //修改
        if(managerVo.getUserId()!=null){
            if(StringUtils.isNotEmpty(managerVo.getPassword())){
                user.setPassword(new BCryptPasswordEncoder().encode(managerVo.getPassword()));
            }
            user.setId(managerVo.getUserId());
            userService.update(user);
            managerMapper.updateByPrimaryKeySelective(manager);

            /**
             * 保存自定义的角色
             */
            for (Role managerVoRole : managerVo.getRoles()) {
                userRoleList.add(managerVoRole.getId());
            }
            userService.addRole(userRoleList,user.getId(),authUser);
        }else {
            //添加
            user.setPassword(new BCryptPasswordEncoder().encode(managerVo.getPassword()));
            user.setLocked(false);
            user.setEnable(true);
            user.setExpiredTime(DateUtils.addDays(new Date(),365).getTime());
            userService.save(user);

            manager.setUserId(user.getId());
            managerMapper.insert(manager);

            UserRole role = new UserRole();
            role.setUserId(user.getId());
            Role storeAdmin= roleService.findBy("name", "商户");
            role.setRoleId(storeAdmin.getId());
            userRoleService.save(role);
        }
        return resultGenerator.genSuccessResult();
    }
}
