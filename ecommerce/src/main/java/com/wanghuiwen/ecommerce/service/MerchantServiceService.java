package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.ecommerce.model.MerchantService;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/13.
 */
public interface MerchantServiceService extends Service<MerchantService> {
    /**
     * 返回商户提供的服务
     * @param merchantId
     * @return
     */
    List<MerchantService> findByMerchantId(Long merchantId);
}
