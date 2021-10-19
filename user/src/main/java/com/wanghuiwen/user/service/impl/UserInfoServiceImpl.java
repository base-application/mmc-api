package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.base.config.ProjectConstant;
import com.wanghuiwen.base.dao.RoleMapper;
import com.wanghuiwen.base.dao.UserMapper;
import com.wanghuiwen.base.dao.UserRoleMapper;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.user.dao.UserInfoMapper;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

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
}
