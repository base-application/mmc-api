package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.FrontCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FrontCategoryMapper extends ApiMapper<FrontCategory> {
    List<FrontCategory> findChild(Long categoryId);
}