package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.UserFollow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowMapper extends ApiMapper<UserFollow> {
    void deleteFollow(Long userId, Long id);
}