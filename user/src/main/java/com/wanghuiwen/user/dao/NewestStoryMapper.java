package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.NewestStory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewestStoryMapper extends ApiMapper<NewestStory> {
}