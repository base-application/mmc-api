package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.CourseCategory;
import com.wanghuiwen.user.vo.AppMasterCourseItemVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseCategoryMapper extends ApiMapper<CourseCategory> {
    List<CourseCategory> list();

    List<AppMasterCourseItemVo> listByCourse();
}