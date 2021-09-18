package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.CommoditySkuMapper;
import com.wanghuiwen.ecommerce.model.CommoditySku;
import com.wanghuiwen.ecommerce.service.CommoditySkuService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/09/09.
 */
@Service
@Transactional
public class CommoditySkuServiceImpl extends AbstractService<CommoditySku> implements CommoditySkuService {
    @Resource
    private CommoditySkuMapper commoditySkuMapper;
}
