package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.CommoditySlideMapper;
import com.wanghuiwen.ecommerce.model.CommoditySlide;
import com.wanghuiwen.ecommerce.service.CommoditySlideService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class CommoditySlideServiceImpl extends AbstractService<CommoditySlide> implements CommoditySlideService {
    @Resource
    private CommoditySlideMapper commoditySlideMapper;
}
