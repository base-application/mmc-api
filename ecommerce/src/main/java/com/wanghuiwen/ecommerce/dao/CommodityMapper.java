package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper extends ApiMapper<Commodity> {
}