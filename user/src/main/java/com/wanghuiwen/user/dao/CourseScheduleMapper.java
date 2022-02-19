package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.CourseSchedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseScheduleMapper extends ApiMapper<CourseSchedule> {
}