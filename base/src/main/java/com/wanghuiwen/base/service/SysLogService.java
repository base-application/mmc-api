package com.wanghuiwen.base.service;
import com.wanghuiwen.base.model.SysLog;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/07/28.
 */
public interface SysLogService extends Service<SysLog> {
    List<ResultMap<String,Object>> list(Map<String, Object> params);
}
