package com.wanghuiwen.service.impl;

import com.wanghuiwen.dao.AppApiMapper;
import com.wanghuiwen.model.App;
import com.wanghuiwen.service.AppService;
import com.wanghuiwen.common.GeneratorSnowflakeId;
import com.wanghuiwen.common.config.UploadConfig;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import com.wanghuiwen.core.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by CodeGenerator on 2019/11/14.
 */
@Service
@Transactional
public class AppServiceImpl extends AbstractService<App> implements AppService {
    Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Resource
    private AppApiMapper appMapper;

    @Resource
    private UploadConfig uploadConfig;

    @Resource
    protected ResultGenerator resultGenerator;

    @Override
    public Result add(App app, HttpServletRequest request) {
        app.setId(GeneratorSnowflakeId.nextId());
        app.setIndexUrl(uploadConfig.getHost()+"app/index/"+app.getId());
        appMapper.insertSelective(app);
        return resultGenerator.genSuccessResult();
    }
}
