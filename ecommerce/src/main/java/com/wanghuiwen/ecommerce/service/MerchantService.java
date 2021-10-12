package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.model.Merchant;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.ecommerce.vo.ManagerVo;
import com.wanghuiwen.ecommerce.vo.MerchantVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/08/03.
 */
public interface MerchantService extends Service<Merchant> {
    Result add(MerchantVo merchant);

    List<Merchant> list(Map<String, Object> params);

    List<ManagerVo> admins(Map<String, Object> params);

    Merchant findByManagerId(Long id);
}
