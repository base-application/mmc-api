package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.vo.ManagerVo;

/**
 * Created by wanghuiwen on 2021/08/03.
 */
public interface ManagerService extends Service<Manager> {
    Result add(ManagerVo manager, AuthUser authUser);
}
