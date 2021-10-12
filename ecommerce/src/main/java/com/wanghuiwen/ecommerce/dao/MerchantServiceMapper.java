package com.wanghuiwen.ecommerce.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.ecommerce.model.MerchantService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerchantServiceMapper extends ApiMapper<MerchantService> {
    List<MerchantService> findByMerchantId(Long merchantId);
}