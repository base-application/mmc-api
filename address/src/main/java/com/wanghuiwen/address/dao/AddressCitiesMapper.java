package com.wanghuiwen.address.dao;

import com.wanghuiwen.address.model.AddressCities;
import com.wanghuiwen.address.vo.CityVo;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressCitiesMapper extends ApiMapper<AddressCities> {
    List<CityVo> selectByCountryId(Integer countryId);

    List<CityVo> selectByStateId(Integer stateId, String name);
}