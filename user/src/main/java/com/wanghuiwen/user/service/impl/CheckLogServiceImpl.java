package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CheckLogMapper;
import com.wanghuiwen.user.model.CheckLog;
import com.wanghuiwen.user.service.CheckLogService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/11/25.
 */
@Service
@Transactional
public class CheckLogServiceImpl extends AbstractService<CheckLog> implements CheckLogService {
    @Resource
    private CheckLogMapper checkLogMapper;
}
