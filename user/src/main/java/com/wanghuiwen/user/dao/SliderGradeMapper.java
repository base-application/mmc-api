package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.SliderGrade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SliderGradeMapper extends ApiMapper<SliderGrade> {
    void deleteBySlider(Integer sliderId);
}