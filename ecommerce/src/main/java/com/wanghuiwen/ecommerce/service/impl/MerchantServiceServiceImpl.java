package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.MerchantServiceMapper;
import com.wanghuiwen.ecommerce.model.MerchantService;
import com.wanghuiwen.ecommerce.service.MerchantServiceService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class MerchantServiceServiceImpl extends AbstractService<MerchantService> implements MerchantServiceService {
    @Resource
    private MerchantServiceMapper merchantServiceMapper;

    @Override
    public List<MerchantService> findByMerchantId(Long merchantId) {

        return merchantServiceMapper.findByMerchantId(merchantId);
    }
}
