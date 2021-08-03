package com.wanghuiwen.address.service;
import com.wanghuiwen.address.model.AddressCountries;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/08/02.
 */
public interface AddressCountriesService extends Service<AddressCountries> {
    List<AddressCountries> list(Map<String, Object> params);
}
