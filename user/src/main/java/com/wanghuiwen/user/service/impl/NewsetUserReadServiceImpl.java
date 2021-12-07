package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NewsetUserReadMapper;
import com.wanghuiwen.user.model.NewsetUserRead;
import com.wanghuiwen.user.service.NewsetUserReadService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/12/02.
 */
@Service
@Transactional
public class NewsetUserReadServiceImpl extends AbstractService<NewsetUserRead> implements NewsetUserReadService {
    @Resource
    private NewsetUserReadMapper newsetUserReadMapper;
}
