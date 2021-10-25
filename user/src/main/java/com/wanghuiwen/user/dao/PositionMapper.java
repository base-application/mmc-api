package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Position;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PositionMapper extends ApiMapper<Position> {
    Position findByName(String name);
}