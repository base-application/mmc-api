package com.wanghuiwen.base.config.auth;

import com.wanghuiwen.base.config.auth.service.DetailsService;
import com.wanghuiwen.base.model.SysWhitelist;
import com.wanghuiwen.base.service.SysWhitelistService;
import com.wanghuiwen.common.JSONUtils;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import com.wanghuiwen.core.response.ResultGenerator;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private ResultGenerator resultGenerator;

    private DetailsService userDetailsService;

    @Resource
    private SysWhitelistService sysWhitelistService;

    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public JwtAuthenticationTokenFilter(DetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {

        String authHeader = request.getHeader(tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead) && !isMatcherAllowedRequest(request)) {
            String authToken = authHeader.substring(tokenHead.length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null && jwtTokenUtil.validateToken(authToken, username)) {
                    //认证信息加入请求
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }
        filterChain.doFilter(request, response);
        }catch (Exception e){
            logger.error("TokenFilterException",e);
            Result result = resultGenerator.genExceptionResult(e);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            if(e instanceof RedisConnectionFailureException){
                result = resultGenerator.genResult(ResultEnum.REDIS_CONNECTION_FAIL);
            }
            if(e instanceof ExpiredJwtException){
                result = resultGenerator.genResult(ResultEnum.UNAUTHORIZED);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
            response.setHeader("Content-Type", "application/json;charset=utf-8");
            response.getWriter().write(JSONUtils.obj2json(result));
            response.getWriter().flush();
        }
    }


    /**
     * 判断当前请求是否在允许请求的范围内
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(HttpServletRequest fi){
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi))
                .toArray().length > 0;
    }

    /**
     *
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest(){
        List<SysWhitelist> whitelists=sysWhitelistService.listAll();

        return whitelists.stream()
                .map(SysWhitelist::getUrl)
                .collect(Collectors.toList());
    }






}
