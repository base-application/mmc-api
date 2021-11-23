package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.UserFollowMapper;
import com.wanghuiwen.user.model.UserFollow;
import com.wanghuiwen.user.service.UserFollowService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/11/19.
 */
@Service
@Transactional
public class UserFollowServiceImpl extends AbstractService<UserFollow> implements UserFollowService {
    @Resource
    private UserFollowMapper userFollowMapper;

    @Override
    public void follow(Long userId, Long id) {
        UserFollow follow = new UserFollow();
        follow.setUserId(userId);
        follow.setFollowUserId(id);
        int count = userFollowMapper.selectCount(follow);
        if(count > 0){
            userFollowMapper.deleteFollow(userId,id);
        }else {
            save(follow);
        }
    }
}
