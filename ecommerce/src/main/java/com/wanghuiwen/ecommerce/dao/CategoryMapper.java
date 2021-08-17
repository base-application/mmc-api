package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper extends ApiMapper<Category> {
    List<Category> selectChild(Long categoryId);

    List<Category> query(@Param("params") Map<String, Object> params);

    /**
     * 返回前端分类包含的后天分类
     * @param categoryId
     * @return
     */
    List<Category> findFront(Long categoryId);

    List<Category> findAllEnable();
}