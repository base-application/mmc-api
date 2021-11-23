package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface GradeService extends Service<Grade> {
    void deleteByEvent(Long eventId);
}
