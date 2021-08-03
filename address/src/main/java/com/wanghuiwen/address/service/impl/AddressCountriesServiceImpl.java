package com.wanghuiwen.address.service.impl;

import com.wanghuiwen.address.dao.AddressCountriesMapper;
import com.wanghuiwen.address.model.AddressCountries;
import com.wanghuiwen.address.service.AddressCountriesService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/08/02.
 */
@Service
@Transactional
public class AddressCountriesServiceImpl extends AbstractService<AddressCountries> implements AddressCountriesService {
    @Resource
    private AddressCountriesMapper addressCountriesMapper;

    @Override
    public List<AddressCountries> list(Map<String, Object> params) {
        return addressCountriesMapper.list(params);
    }
}
