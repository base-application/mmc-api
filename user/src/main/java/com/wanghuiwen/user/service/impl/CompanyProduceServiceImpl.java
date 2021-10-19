package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CompanyProduceMapper;
import com.wanghuiwen.user.model.CompanyProduce;
import com.wanghuiwen.user.service.CompanyProduceService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class CompanyProduceServiceImpl extends AbstractService<CompanyProduce> implements CompanyProduceService {
    @Resource
    private CompanyProduceMapper companyProduceMapper;
}
