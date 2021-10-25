package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Advertisement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertisementMapper extends ApiMapper<Advertisement> {
    Advertisement pull(Long id);
}