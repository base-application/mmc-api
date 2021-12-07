package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Slider;
import com.wanghuiwen.user.vo.SliderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SliderMapper extends ApiMapper<Slider> {
    List<SliderVo> list();

    List<SliderVo> userList(Integer gradeId,Integer groupId);
}