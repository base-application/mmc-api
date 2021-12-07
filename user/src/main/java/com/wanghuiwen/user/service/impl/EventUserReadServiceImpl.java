package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.EventUserReadMapper;
import com.wanghuiwen.user.model.EventUserRead;
import com.wanghuiwen.user.service.EventUserReadService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/12/02.
 */
@Service
@Transactional
public class EventUserReadServiceImpl extends AbstractService<EventUserRead> implements EventUserReadService {
    @Resource
    private EventUserReadMapper eventUserReadMapper;
}
