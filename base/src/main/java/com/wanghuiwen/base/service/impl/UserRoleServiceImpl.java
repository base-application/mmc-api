package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.UserRoleMapper;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.base.service.UserRoleService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;
}
