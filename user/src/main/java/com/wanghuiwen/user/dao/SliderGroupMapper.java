package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.SliderGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SliderGroupMapper extends ApiMapper<SliderGroup> {
    void deleteBySlider(Integer sliderId);
}