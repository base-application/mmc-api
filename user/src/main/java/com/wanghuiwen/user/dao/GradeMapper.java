package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Grade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeMapper extends ApiMapper<Grade> {
    Grade findByName(String name);

    void deleteByEvent(Long eventId);
}