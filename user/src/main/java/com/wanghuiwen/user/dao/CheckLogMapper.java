package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.CheckLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckLogMapper extends ApiMapper<CheckLog> {
}