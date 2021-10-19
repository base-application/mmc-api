package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NotificationUserMapper;
import com.wanghuiwen.user.model.NotificationUser;
import com.wanghuiwen.user.service.NotificationUserService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NotificationUserServiceImpl extends AbstractService<NotificationUser> implements NotificationUserService {
    @Resource
    private NotificationUserMapper notificationUserMapper;
}
