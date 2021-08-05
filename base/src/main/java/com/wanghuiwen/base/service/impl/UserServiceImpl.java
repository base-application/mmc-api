package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.config.auth.JwtTokenUtil;
import com.wanghuiwen.base.dao.UserMapper;
import com.wanghuiwen.base.dao.UserRoleMapper;
import com.wanghuiwen.base.model.Api;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.base.service.ApiService;
import com.wanghuiwen.base.service.RoleService;
import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.response.ResultGenerator;
import com.wanghuiwen.core.response.ResultMessage;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private ResultGenerator resultGenerator;
    @Resource
    private RoleService roleService;

    @Resource
    private ApiService apiService;


    @Override
    public List<User> list(Map<String, Object> params) {
        return userMapper.list(params);
    }

    @Override
    @CacheEvict(value="User::Role",key = "#userId")
    public Result addRole(List<Long> roles, Long userId) {
        User user = findById(userId);
        if (user == null) return resultGenerator.genFailResult(ResultEnum.NO_RELATED_USER);

        List<UserRole> userRoles = new ArrayList<>();
        for (Long id : roles) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(id);
            userRoles.add(userRole);
        }

        userMapper.deleteRoleById(userId);
        userRoleMapper.insertListNoAuto(userRoles);
        return resultGenerator.genSuccessResult();
    }

    @Override
    public Result login(AuthUser userDetails) {
        Map<String, Object> res = new HashMap<>();

        String jwtToken = jwtTokenUtil.generateToken(userDetails.getUsername());
        userDetails.setPassword("");
        res.put("role",userDetails.getRoles());
        res.put("token", jwtToken);
        res.put("id", userDetails.getId());
        res.put("nickname", userDetails.getNickName());
        res.put("avatar", userDetails.getAvatar());
        res.put("username", userDetails.getUsername());

        /**
         * 设置登陆过期时间
         */

        User user = new User();
        user.setId(userDetails.getId());
        user.setCredentialsExpiredTime(jwtTokenUtil.getExpiredDate(jwtToken).getTime());
        update(user);

        return resultGenerator.genSuccessResult(ResultEnum.LOGIN_SUCCESS,res);
    }

    @Override
    public List<Api> getApis(Long id) {
        List<Api> apis = new ArrayList<>();
        List<Role> roles = roleService.getByUser(id);
        for (Role role : roles) {
            List<Api> roleApi = apiService.getByRole(role.getId());
            apis.addAll(roleApi);
        }
        return apis;
    }
    @Override
    @Cacheable(value="User",key = "#s")
    public User findByLoginName(String s) {
        return findBy("loginName",s);
    }
}
