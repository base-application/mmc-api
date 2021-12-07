package com.wanghuiwen.base.config.auth.handler;

import com.wanghuiwen.common.JSONUtils;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.response.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 它负责启动未经过身份验证的用户的身份验证过程(当他们试图访问受保护的资源
 */
public class GoAuthenticationEntryPoint  implements AuthenticationEntryPoint {
    ResultGenerator resultGenerator;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public GoAuthenticationEntryPoint(ResultGenerator resultGenerator) {
        this.resultGenerator = resultGenerator;
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        Result result = resultGenerator.genResult(ResultEnum.UNAUTHORIZED);
        logger.warn("身份验证出错",e);
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.getWriter().write(JSONUtils.obj2json(result));
        httpServletResponse.getWriter().flush();
    }

}
