package com.wanghuiwen.base.config.auth.handler;

import com.wanghuiwen.common.JSONUtils;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.response.ResultGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoLogoutSuccessHandler implements LogoutSuccessHandler {
    ResultGenerator resultGenerator;

    public GoLogoutSuccessHandler(ResultGenerator resultGenerator) {
        this.resultGenerator = resultGenerator;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Result result = resultGenerator.genResult(ResultEnum.LOGIN_OUT_SUCCESS);

        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.getWriter().write(JSONUtils.obj2json(result));
        httpServletResponse.getWriter().flush();

    }

}
