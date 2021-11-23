package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CompanyProduceMapper;
import com.wanghuiwen.user.dao.UserCompanyMapper;
import com.wanghuiwen.user.model.CompanyProduce;
import com.wanghuiwen.user.model.UserCompany;
import com.wanghuiwen.user.service.UserCompanyService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.CompanyVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class UserCompanyServiceImpl extends AbstractService<UserCompany> implements UserCompanyService {
    @Resource
    private UserCompanyMapper userCompanyMapper;
    @Resource
    private CompanyProduceMapper companyProduceMapper;


    @Override
    public Long companyUpdate(CompanyVo companyVo) {

        UserCompany company = new UserCompany();
        BeanUtils.copyProperties(companyVo,company);
        saveOrUpdate(company);
        companyProduceMapper.deleteByCompanyId(company.getCompanyId());

        companyVo.getProducePictures().forEach(e -> e.setCompanyId(company.getCompanyId()));
        if(!CollectionUtils.isEmpty(companyVo.getProducePictures())){
            companyProduceMapper.insertList(companyVo.getProducePictures());
        }

        return  company.getCompanyId();
    }
}
