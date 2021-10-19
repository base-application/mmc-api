package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NotificationMapper;
import com.wanghuiwen.user.model.Notification;
import com.wanghuiwen.user.service.NotificationService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NotificationServiceImpl extends AbstractService<Notification> implements NotificationService {
    @Resource
    private NotificationMapper notificationMapper;
}
