package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.MmcGroupMapper;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.service.MmcGroupService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class MmcGroupServiceImpl extends AbstractService<MmcGroup> implements MmcGroupService {
    @Resource
    private MmcGroupMapper mmcGroupMapper;
}
