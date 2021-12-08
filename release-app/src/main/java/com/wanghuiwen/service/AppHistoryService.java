package com.wanghuiwen.service;
import com.wanghuiwen.model.AppHistory;
import com.wanghuiwen.core.service.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/11/14.
 */
public interface AppHistoryService extends Service<AppHistory> {

    List<AppHistory> findeByAppId(Map<String, Object> params);

    AppHistory findLast(Long appId,String platform);
}
