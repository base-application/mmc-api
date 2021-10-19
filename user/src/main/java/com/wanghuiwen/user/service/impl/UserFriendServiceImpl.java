package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.dao.UserFriendApplyMapper;
import com.wanghuiwen.user.dao.UserFriendMapper;
import com.wanghuiwen.user.model.UserFriend;
import com.wanghuiwen.user.model.UserFriendApply;
import com.wanghuiwen.user.service.UserFriendService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class UserFriendServiceImpl extends AbstractService<UserFriend> implements UserFriendService {
    @Resource
    private UserFriendMapper userFriendMapper;
    @Resource
    private UserFriendApplyMapper  userFriendApplyMapper;

    @Override
    public void apply(Long idolId, AuthUser authUser) {

        UserFriend userFriend = userFriendMapper.selectByPrimaryKey(idolId,authUser.getId());
        if(userFriend!=null) throw  new ServiceException("已经是好友了");

        UserFriendApply apply = new UserFriendApply();
        apply.setCreateTime(new Date().getTime());
        apply.setFansId(authUser.getId());
        apply.setIdolId(idolId);
        apply.setState(Const.USER_FRIEND_APPLY_WAITING);

        userFriendApplyMapper.insertSelective(apply);
    }

    @Override
    public void agree(Long id, AuthUser authUser) {
        UserFriendApply apply =  userFriendApplyMapper.selectByPrimaryKey(id);
        if(!apply.getIdolId().equals(authUser.getId())) throw  new ServiceException("不是本人的好友请求");

        UserFriend userFriend = userFriendMapper.selectByPrimaryKey(apply.getFansId(),authUser.getId());
        if(userFriend==null){
            UserFriend friend = new UserFriend();
            friend.setFansId(apply.getFansId());
            friend.setIdolId(apply.getIdolId());
            friend.setCreateTime(new Date().getTime());
            userFriendMapper.insert(friend);
        }
        apply.setState(Const.USER_FRIEND_APPLY_AGREE);
        userFriendApplyMapper.updateByPrimaryKeySelective(apply);
    }
}
