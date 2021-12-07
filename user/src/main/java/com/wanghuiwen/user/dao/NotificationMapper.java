package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Notification;
import com.wanghuiwen.user.vo.NotificationUserListVo;
import com.wanghuiwen.user.vo.NotificationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NotificationMapper extends ApiMapper<Notification> {
    List<NotificationVo> list(@Param("params") Map<String, Object> params);

    List<NotificationUserListVo> userList(@Param("params")Map<String, Object> params);

   int noRead(Long uid);
}