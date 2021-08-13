package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.FrontCategoryItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FrontCategoryItemMapper extends ApiMapper<FrontCategoryItem> {
    void deleteByFrontCategoryId(Long categoryId);
}