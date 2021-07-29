package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.SysLogMapper;
import com.wanghuiwen.base.model.SysLog;
import com.wanghuiwen.base.service.SysLogService;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/07/28.
 */
@Service
@Transactional
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public List<ResultMap<String,Object>> list(Map<String, Object> params) {
        return sysLogMapper.list(params);
    }
}
