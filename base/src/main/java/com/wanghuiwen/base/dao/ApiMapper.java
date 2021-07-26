package com.wanghuiwen.base.dao;

import com.wanghuiwen.base.model.Api;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiMapper extends com.wanghuiwen.core.ApiMapper<Api> {
    List<Api> getByUser(Long userId);

    Api selectByUrlAndMethod(String url, String method);

    List<Api> getByRole(Long roleId);
}