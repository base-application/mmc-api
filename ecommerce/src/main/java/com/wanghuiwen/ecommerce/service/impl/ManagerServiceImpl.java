package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.ManagerMapper;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.service.ManagerService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/03.
 */
@Service
@Transactional
public class ManagerServiceImpl extends AbstractService<Manager> implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;
}
