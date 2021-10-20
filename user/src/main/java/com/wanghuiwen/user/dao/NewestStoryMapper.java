package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.NewestStory;
import com.wanghuiwen.user.vo.NewestStoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewestStoryMapper extends ApiMapper<NewestStory> {
    List<NewestStoryVo> list(Map<String, Object> params);
}