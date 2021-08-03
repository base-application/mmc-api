package com.wanghuiwen.address.service.impl;

import com.wanghuiwen.address.dao.AddressDistrictMapper;
import com.wanghuiwen.address.model.AddressDistrict;
import com.wanghuiwen.address.service.AddressDistrictService;
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
public class AddressDistrictServiceImpl extends AbstractService<AddressDistrict> implements AddressDistrictService {
    @Resource
    private AddressDistrictMapper addressDistrictMapper;

    @Override
    public List<AddressDistrict> listByCityId(Integer cityId) {
        return addressDistrictMapper.selectByCityId(cityId);
    }
}
