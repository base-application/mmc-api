package com.wanghuiwen.address.service.impl;

import com.wanghuiwen.address.dao.AddressCitiesMapper;
import com.wanghuiwen.address.dao.AddressCountriesMapper;
import com.wanghuiwen.address.model.AddressCities;
import com.wanghuiwen.address.model.AddressCountries;
import com.wanghuiwen.address.service.AddressCitiesService;
import com.wanghuiwen.address.vo.CityVo;
import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wanghuiwen on 2021/08/02.
 */
@Service
@Transactional
public class AddressCitiesServiceImpl extends AbstractService<AddressCities> implements AddressCitiesService {
    @Resource
    private AddressCitiesMapper addressCitiesMapper;
    @Resource
    private AddressCountriesMapper addressCountriesMapper;

    @Override
    public List<CityVo> listByCountryId(Integer countryId) {
        return addressCitiesMapper.selectByCountryId(countryId);
    }

    @Override
    public List<CityVo> listByCountryCode(String countryCode) {
        AddressCountries country = addressCountriesMapper.findByCode(countryCode);
        if(country == null) throw new ServiceException("没有找到相关国家", Integer.toString(ResultEnum.NO_COUNTRY.getCode()));
        return addressCitiesMapper.selectByCountryId(country.getId());
    }

    @Override
    public List<CityVo> listByStateId(Integer stateId, String name) {
        return addressCitiesMapper.selectByStateId(stateId,name);
    }
}
