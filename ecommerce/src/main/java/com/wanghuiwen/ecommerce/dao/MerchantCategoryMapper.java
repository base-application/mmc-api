package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.ecommerce.model.MerchantCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerchantCategoryMapper extends ApiMapper<MerchantCategory> {
    List<MerchantCategory> getChild(Long categoryId);
}