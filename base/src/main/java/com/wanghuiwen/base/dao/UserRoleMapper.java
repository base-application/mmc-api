package com.wanghuiwen.base.dao;

import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper extends ApiMapper<UserRole> {
}