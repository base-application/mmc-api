package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.RoleMenuMapper;
import com.wanghuiwen.base.model.RoleMenu;
import com.wanghuiwen.base.service.RoleMenuService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class RoleMenuServiceImpl extends AbstractService<RoleMenu> implements RoleMenuService {
    @Resource
    private RoleMenuMapper roleMenuMapper;
}
