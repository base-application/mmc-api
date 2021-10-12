package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.CommoditySkuAttr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommoditySkuAttrMapper extends ApiMapper<CommoditySkuAttr> {
    void deleteBySpec(Long specsId);
}