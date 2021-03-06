package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.NewsetStoryPicture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsetStoryPictureMapper extends ApiMapper<NewsetStoryPicture> {
    void deleteByNew(Long storyId);
}