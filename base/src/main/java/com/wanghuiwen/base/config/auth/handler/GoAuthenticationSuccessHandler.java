package com.wanghuiwen.base.config.auth.handler;

import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.common.JSONUtils;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;

    public GoAuthenticationSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");

        AuthUser userDetails = (AuthUser) authentication.getPrincipal();

        Result result = userService.login(userDetails);
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.getWriter().write(JSONUtils.obj2json(result));
        httpServletResponse.getWriter().flush();

    }


}
