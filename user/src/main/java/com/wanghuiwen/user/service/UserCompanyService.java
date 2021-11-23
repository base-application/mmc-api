package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.UserCompany;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.CompanyVo;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface UserCompanyService extends Service<UserCompany> {
    Long companyUpdate(CompanyVo companyVo);
}
