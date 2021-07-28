package com.wanghuiwen.core.controller;

import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.response.ResultGenerator;
import org.springframework.security.core.Authentication;

import javax.annotation.Resource;

public abstract class Ctrl implements IControllerLog {
    @Resource
    protected ResultGenerator resultGenerator;

    protected AuthUser getAuthUser(Authentication authentication){
        if(authentication == null) throw  new ServiceException("当前用户未登录");
        return (AuthUser) authentication.getPrincipal();
    }

}
