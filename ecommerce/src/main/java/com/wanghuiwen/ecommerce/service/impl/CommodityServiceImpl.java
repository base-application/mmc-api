package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.CommodityMapper;
import com.wanghuiwen.ecommerce.model.Commodity;
import com.wanghuiwen.ecommerce.service.CommodityService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class CommodityServiceImpl extends AbstractService<Commodity> implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;
}
