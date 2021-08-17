package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.SpecsAttributeMapper;
import com.wanghuiwen.ecommerce.model.SpecsAttribute;
import com.wanghuiwen.ecommerce.service.SpecsAttributeService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class SpecsAttributeServiceImpl extends AbstractService<SpecsAttribute> implements SpecsAttributeService {
    @Resource
    private SpecsAttributeMapper specsAttributeMapper;
}
