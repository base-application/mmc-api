package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.CompanyProduce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyProduceMapper extends ApiMapper<CompanyProduce> {

   List<CompanyProduce> selectByCompanyId(Long id);

  void  deleteByCompanyId(Long companyId);
}