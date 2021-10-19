package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NotificationGroupMapper;
import com.wanghuiwen.user.model.NotificationGroup;
import com.wanghuiwen.user.service.NotificationGroupService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NotificationGroupServiceImpl extends AbstractService<NotificationGroup> implements NotificationGroupService {
    @Resource
    private NotificationGroupMapper notificationGroupMapper;
}
