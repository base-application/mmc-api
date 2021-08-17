package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.CommodityServiceMapper;
import com.wanghuiwen.ecommerce.model.CommodityService;
import com.wanghuiwen.ecommerce.service.CommodityServiceService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class CommodityServiceServiceImpl extends AbstractService<CommodityService> implements CommodityServiceService {
    @Resource
    private CommodityServiceMapper commodityServiceMapper;
}
