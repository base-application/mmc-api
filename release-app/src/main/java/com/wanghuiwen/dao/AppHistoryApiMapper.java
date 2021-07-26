package com.wanghuiwen.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.model.AppHistory;

import java.util.List;
import java.util.Map;

public interface AppHistoryApiMapper extends ApiMapper<AppHistory> {
    List<AppHistory> selectByAppID(Map<String, Object> params);

    AppHistory findLast(Long appid);
}