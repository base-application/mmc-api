package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.EventGroupMapper;
import com.wanghuiwen.user.model.EventGroup;
import com.wanghuiwen.user.service.EventGroupService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class EventGroupServiceImpl extends AbstractService<EventGroup> implements EventGroupService {
    @Resource
    private EventGroupMapper eventGroupMapper;
}
