package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.UserFriend;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFriendMapper extends ApiMapper<UserFriend> {
    UserFriend selectByPrimaryKey(Long idolId, Long fansId);
}