package com.wanghuiwen.address.dao;

import com.wanghuiwen.address.model.AddressCities;
import com.wanghuiwen.address.model.AddressCountries;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AddressCountriesMapper extends ApiMapper<AddressCountries> {
    AddressCountries findByCode(String countryCode);

    List<AddressCountries> list(@Param("params") Map<String, Object> params);
}