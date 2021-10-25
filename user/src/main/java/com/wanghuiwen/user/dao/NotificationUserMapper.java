package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.NotificationUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationUserMapper extends ApiMapper<NotificationUser> {
    NotificationUser selectByUser(Integer notificationId, Long userId);

    void updateByUser(NotificationUser notificationUser);
}