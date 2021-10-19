package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.UserFriendApplyMapper;
import com.wanghuiwen.user.model.UserFriendApply;
import com.wanghuiwen.user.service.UserFriendApplyService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class UserFriendApplyServiceImpl extends AbstractService<UserFriendApply> implements UserFriendApplyService {
    @Resource
    private UserFriendApplyMapper userFriendApplyMapper;
}
