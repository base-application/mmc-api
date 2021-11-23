package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.UserFollow;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

/**
 * Created by wanghuiwen on 2021/11/19.
 */
public interface UserFollowService extends Service<UserFollow> {
    void follow(Long userId, Long id);
}
