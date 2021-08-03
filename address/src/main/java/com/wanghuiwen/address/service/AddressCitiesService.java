package com.wanghuiwen.address.service;
import com.wanghuiwen.address.model.AddressCities;
import com.wanghuiwen.address.vo.CityVo;
import com.wanghuiwen.core.service.Service;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/02.
 */
public interface AddressCitiesService extends Service<AddressCities> {
    List<CityVo> listByCountryId(Integer countryId);

    List<CityVo> listByCountryCode(String countryCode);

    List<CityVo> listByStateId(Integer stateId, String name);
}
