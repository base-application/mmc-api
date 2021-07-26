package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.RoleApiMapper;
import com.wanghuiwen.base.model.RoleApi;
import com.wanghuiwen.base.service.RoleApiService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class RoleApiServiceImpl extends AbstractService<RoleApi> implements RoleApiService {
    @Resource
    private RoleApiMapper roleApiMapper;
}
