package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.SpecsValueMapper;
import com.wanghuiwen.ecommerce.model.SpecsValue;
import com.wanghuiwen.ecommerce.service.SpecsValueService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class SpecsValueServiceImpl extends AbstractService<SpecsValue> implements SpecsValueService {
    @Resource
    private SpecsValueMapper specsValueMapper;
}
