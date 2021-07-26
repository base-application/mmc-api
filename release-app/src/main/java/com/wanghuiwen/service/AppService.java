package com.wanghuiwen.service;

import com.wanghuiwen.model.App;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.service.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by CodeGenerator on 2019/11/14.
 */
public interface AppService extends Service<App> {

    Result add(App app, HttpServletRequest request);
}
