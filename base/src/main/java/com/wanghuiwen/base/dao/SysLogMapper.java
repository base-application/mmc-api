package com.wanghuiwen.base.dao;

import com.wanghuiwen.base.model.SysLog;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysLogMapper extends ApiMapper<SysLog> {
    List<ResultMap<String,Object>> list(@Param("params") Map<String, Object> params);
}