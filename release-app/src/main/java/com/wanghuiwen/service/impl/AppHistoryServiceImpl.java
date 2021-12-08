package com.wanghuiwen.service.impl;

import com.wanghuiwen.dao.AppHistoryApiMapper;
import com.wanghuiwen.model.AppHistory;
import com.wanghuiwen.service.AppHistoryService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/11/14.
 */
@Service
@Transactional
public class AppHistoryServiceImpl extends AbstractService<AppHistory> implements AppHistoryService {
    @Resource
    private AppHistoryApiMapper appHistoryMapper;


    @Override
    public List<AppHistory> findeByAppId(Map<String, Object> params) {
        List<AppHistory> res = appHistoryMapper.selectByAppID(params);
        return res;
    }

    @Override
    public AppHistory findLast(Long appId,String platform) {
        AppHistory last = appHistoryMapper.findLast(appId,platform);
        return last;
    }
}
