package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.model.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MerchantMapper extends ApiMapper<Merchant> {
    List<Merchant> list(@Param("params") Map<String, Object> params);

    Merchant selectByManagerId(Long id);
}