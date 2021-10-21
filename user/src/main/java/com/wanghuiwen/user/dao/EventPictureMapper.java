package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.EventPicture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventPictureMapper extends ApiMapper<EventPicture> {
    void deleteByEvent(Long eventId);
}