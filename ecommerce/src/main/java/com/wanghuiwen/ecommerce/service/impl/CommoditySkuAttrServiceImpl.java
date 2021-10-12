package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.CommoditySkuAttrMapper;
import com.wanghuiwen.ecommerce.model.CommoditySkuAttr;
import com.wanghuiwen.ecommerce.service.CommoditySkuAttrService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/09/09.
 */
@Service
@Transactional
public class CommoditySkuAttrServiceImpl extends AbstractService<CommoditySkuAttr> implements CommoditySkuAttrService {
    @Resource
    private CommoditySkuAttrMapper commoditySkuAttrMapper;
}
