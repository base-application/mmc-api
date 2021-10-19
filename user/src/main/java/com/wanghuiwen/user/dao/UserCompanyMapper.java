package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.CompanyProduce;
import com.wanghuiwen.user.model.UserCompany;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCompanyMapper extends ApiMapper<UserCompany> {
}