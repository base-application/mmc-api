package com.wanghuiwen.base.config.auth.handler;

import com.wanghuiwen.common.JSONUtils;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.response.ResultGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GoAccessDeniedHandler implements AccessDeniedHandler {
    ResultGenerator resultGenerator;

    public GoAccessDeniedHandler(ResultGenerator resultGenerator) {
        this.resultGenerator = resultGenerator;
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        Result result = resultGenerator.genResult(ResultEnum.FORBIDDEN);
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        httpServletResponse.getWriter().write(JSONUtils.obj2json(result));
        httpServletResponse.getWriter().flush();
    }
}
