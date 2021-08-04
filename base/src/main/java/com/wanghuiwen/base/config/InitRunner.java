package com.wanghuiwen.base.config;

import com.wanghuiwen.base.model.Api;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.service.ApiService;
import com.wanghuiwen.base.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by wanghuiwen on 17-2-12.
 * 服务启动执行
 */
@Component
public class InitRunner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ApiService apiService;
    @Resource
    private RoleService roleService;
    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Resource
    private RedisTemplate redisTemplate;


    @CacheEvict(value=ProjectConstant.API_LIST_CACHE_KEY, beforeInvocation=true)
    public void run(String... strings) {
        initPower();
        initRole();
    }

    private void initPower() {

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            Api power = new Api();

            /**
             * 框架本身的Controller 不处理
             */
            if(m.getValue().getBeanType().isAssignableFrom(org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.class)){
                continue;
            }

            if (m.getValue().getMethod().getDeclaringClass().isAnnotationPresent(io.swagger.annotations.Api.class)) {
                String model = m.getValue().getMethod().getDeclaringClass().getAnnotation(io.swagger.annotations.Api.class).value(); // 类名
                power.setModule(model);
            }else {
                power.setModule("其他");
            }

            PatternsRequestCondition p = m.getKey().getPatternsCondition();

            for (RequestMethod method : m.getKey().getMethodsCondition().getMethods()) {
                power.setMethod(method.toString());
            }

            assert p != null;

            for (String url : p.getPatterns()) {
                if (StringUtils.isEmpty(url)) continue;
                power.setUrl(url);
            }

            Api old = apiService.selectByUrlAndMethod(power.getUrl(),power.getMethod());
            if(old!=null){
                power.setId(old.getId());
            }


            if(m.getKey().getName() == null) {
                power.setName(power.getUrl());
            }else {
                power.setName(m.getKey().getName());
            }

            apiService.saveOrUpdate(power);
        }

    }

    private void initRole() {
        for (Role r : ProjectConstant.initRole) {
            if (roleService.findBy("name", r.getName()) == null)
                roleService.save(r);
        }
    }



}
