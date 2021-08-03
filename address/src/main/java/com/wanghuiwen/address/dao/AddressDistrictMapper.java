package com.wanghuiwen.address.dao;

import com.wanghuiwen.address.model.AddressDistrict;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressDistrictMapper extends ApiMapper<AddressDistrict> {
    List<AddressDistrict> selectByCityId(Integer cityId);

    List<AddressDistrict> selectByCountryId(Integer id);
}