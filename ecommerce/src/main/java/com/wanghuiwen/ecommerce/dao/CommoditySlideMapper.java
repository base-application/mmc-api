package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.CommoditySlide;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommoditySlideMapper extends ApiMapper<CommoditySlide> {
    List<CommoditySlide> findByCommodityId(Long commodityId);
}