package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.RoleApiMapper;
import com.wanghuiwen.base.dao.RoleMapper;
import com.wanghuiwen.base.dao.RoleMenuMapper;
import com.wanghuiwen.base.model.*;
import com.wanghuiwen.base.service.RoleService;
import com.wanghuiwen.base.vo.RoleApiAdd;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import com.wanghuiwen.core.response.ResultMessage;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleApiMapper roleApiMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Override
    public List<Role> getByUser(Long id) {
        return roleMapper.getByUser(id);
    }

    @Override
    public Result addApi(RoleApiAdd add) {

        Role role = findById(add.getRoleId());
        if (role == null) return ResultGenerator.genFailResult(ResultMessage.NO_RELATED_USER);

        List<RoleApi> roleApis = new ArrayList<>();
        for (Long id : add.getApi()) {
            RoleApi roleApi = new RoleApi();
            roleApi.setApiId(id);
            roleApi.setRoleId(add.getRoleId());
            roleApis.add(roleApi);
        }

        roleMapper.deleteApiById(add.getRoleId());
        roleApiMapper.insertListNoAuto(roleApis);

        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result addMenu(RoleApiAdd add) {


        Role role = findById(add.getRoleId());

        if (role == null) return ResultGenerator.genFailResult(ResultMessage.NO_RELATED_USER);

        List<RoleMenu> roleMenus = new ArrayList<>();
        for (Long id : add.getApi()) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(id);
            roleMenu.setRoleId(add.getRoleId());
            roleMenus.add(roleMenu);
        }

        roleMapper.deleteMenuById(add.getRoleId());
        roleMenuMapper.insertListNoAuto(roleMenus);

        return ResultGenerator.genSuccessResult();
    }
}
