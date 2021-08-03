package com.wanghuiwen.address.service;
import com.wanghuiwen.address.model.AddressStates;
import com.wanghuiwen.address.vo.StateVo;
import com.wanghuiwen.core.service.Service;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/02.
 */
public interface AddressStatesService extends Service<AddressStates> {
    List<StateVo> listByCountryCode(String country, String name);

    List<StateVo> listAllByCountryCode(String country);
}
