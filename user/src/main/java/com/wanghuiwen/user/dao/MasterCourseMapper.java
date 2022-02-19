package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.MasterCourse;
import com.wanghuiwen.user.vo.CourseAddVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MasterCourseMapper extends ApiMapper<MasterCourse> {
    CourseAddVo detail(Integer id);

    List<MasterCourse> list(@Param("params")Map<String, Object> params);

    List<MasterCourse> listByCourse(Long courseId);
}