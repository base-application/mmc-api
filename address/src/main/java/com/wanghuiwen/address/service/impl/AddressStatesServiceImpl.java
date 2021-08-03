package com.wanghuiwen.address.service.impl;

import com.wanghuiwen.address.dao.AddressCitiesMapper;
import com.wanghuiwen.address.dao.AddressCountriesMapper;
import com.wanghuiwen.address.dao.AddressDistrictMapper;
import com.wanghuiwen.address.dao.AddressStatesMapper;
import com.wanghuiwen.address.model.AddressCountries;
import com.wanghuiwen.address.model.AddressDistrict;
import com.wanghuiwen.address.model.AddressStates;
import com.wanghuiwen.address.service.AddressStatesService;
import com.wanghuiwen.address.vo.CityVo;
import com.wanghuiwen.address.vo.StateVo;
import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/08/02.
 */
@Service
@Transactional
public class AddressStatesServiceImpl extends AbstractService<AddressStates> implements AddressStatesService {
    @Resource
    private AddressStatesMapper addressStatesMapper;
    @Resource
    private AddressCitiesMapper addressCitiesMapper;
    @Resource
    private AddressDistrictMapper addressDistrictMapper;
    @Resource
    private AddressCountriesMapper addressCountriesMapper;

    @Override
    public List<StateVo> listByCountryCode(String country, String name) {
        return addressStatesMapper.listByCountryCode(country,name);
    }

    @Override
    public List<StateVo> listAllByCountryCode(String countryCode) {
        AddressCountries country = addressCountriesMapper.findByCode(countryCode);
        if(country == null) throw new ServiceException("没有找到相关国家", Integer.toString(ResultEnum.NO_COUNTRY.getCode()));
        List<StateVo> states =  addressStatesMapper.listByCountryCode(countryCode, null);
        List<CityVo> cities = addressCitiesMapper.selectByCountryId(country.getId());
        List<AddressDistrict> districts = addressDistrictMapper.selectByCountryId(country.getId());

        Map<Integer,List<AddressDistrict>> dg = districts.stream().collect(Collectors.groupingBy(AddressDistrict::getCityId));

        for (CityVo city : cities) {
            city.setDistrictList(dg.get(city.getId()));
        }

        Map<Integer, List<CityVo>> cityVoMap = cities.stream().collect(Collectors.groupingBy(CityVo::getStateId));

        for (StateVo state : states) {
            state.setCities(cityVoMap.get(state.getId()));
        }
        return states;
    }
}
