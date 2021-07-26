package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.ApiMapper;
import com.wanghuiwen.base.model.Api;
import com.wanghuiwen.base.service.ApiService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class ApiServiceImpl extends AbstractService<Api> implements ApiService {
    @Resource
    private ApiMapper apiMapper;

    @Override
    public List<Api> getByUser(Long id) {
        return apiMapper.getByUser(id);
    }

    @Override
    public Api selectByUrlAndMethod(String url, String method) {
        return apiMapper.selectByUrlAndMethod(url,method);
    }

    @Override
    public List<Api> getByRole(Long roleId) {
        return apiMapper.getByRole(roleId);
    }
}
