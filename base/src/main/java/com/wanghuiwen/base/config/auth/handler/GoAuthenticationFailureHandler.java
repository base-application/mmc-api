package com.wanghuiwen.base.config.auth.handler;

import com.wanghuiwen.common.JSONUtils;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.response.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ResultGenerator resultGenerator;

    public GoAuthenticationFailureHandler(ResultGenerator resultGenerator) {
        this.resultGenerator = resultGenerator;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {

        logger.warn("身份验证出错",e);

        Result result = resultGenerator.genExceptionResult(e);
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.getWriter().write(JSONUtils.obj2json(result));
        httpServletResponse.getWriter().flush();
    }

}
