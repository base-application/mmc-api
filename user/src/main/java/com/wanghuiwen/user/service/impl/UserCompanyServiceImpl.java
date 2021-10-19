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
    public void companyUpdate(CompanyVo companyVo) {

        UserCompany company = new UserCompany();
        BeanUtils.copyProperties(companyVo,company);
        saveOrUpdate(company);

        List<CompanyProduce> produceList = companyProduceMapper.selectByCompanyId(company.getCompanyId());

        //删除
        List<Long> remove =  produceList.stream().filter( item -> companyVo.getProducePictures().stream().noneMatch( vo-> item.getProduceId().equals(vo.getProduceId()))).map(CompanyProduce::getProduceId).collect(Collectors.toList());
        companyProduceMapper.deleteByIds(String.join(",", StringUtils.join(remove.toArray(), ",")));

        //新增
        List<CompanyProduce> add =  companyVo.getProducePictures().stream().filter( item -> produceList.stream().noneMatch( vo-> item.getProduceId().equals(vo.getProduceId()))).collect(Collectors.toList());
        companyProduceMapper.insertList(add);

        //修改
        List<CompanyProduce> update =  produceList.stream().filter( item -> companyVo.getProducePictures().stream().anyMatch( vo-> item.getProduceId().equals(vo.getProduceId()))).collect(Collectors.toList());

        for (CompanyProduce companyProduce : update) {
            companyProduceMapper.updateByPrimaryKey(companyProduce);
        }
    }
}
