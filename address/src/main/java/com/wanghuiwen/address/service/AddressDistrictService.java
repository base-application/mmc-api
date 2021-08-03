package com.wanghuiwen.address.service;
import com.wanghuiwen.address.model.AddressDistrict;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/02.
 */
public interface AddressDistrictService extends Service<AddressDistrict> {
    List<AddressDistrict> listByCityId(Integer cityId);
}
