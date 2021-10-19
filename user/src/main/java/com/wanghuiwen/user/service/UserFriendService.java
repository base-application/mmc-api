package com.wanghuiwen.user.service;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.user.model.UserFriend;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface UserFriendService extends Service<UserFriend> {
    void apply(Long idolId, AuthUser authUser);

    void agree(Long id, AuthUser authUser);
}
