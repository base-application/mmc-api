package com.wanghuiwen.address.dao;

import com.wanghuiwen.address.model.AddressStates;
import com.wanghuiwen.address.vo.StateVo;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressStatesMapper extends ApiMapper<AddressStates> {
    List<StateVo> listByCountryCode(String country, String name);
}