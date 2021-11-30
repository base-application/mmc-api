package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.MmcGroupMapper;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.service.MmcGroupService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.GroupUserVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class MmcGroupServiceImpl extends AbstractService<MmcGroup> implements MmcGroupService {
    @Resource
    private MmcGroupMapper mmcGroupMapper;

    @Override
    public List<GroupUserVo> listUser(Long uid, String groupName) {
        return mmcGroupMapper.listUser(uid,groupName);
    }

    @Override
    public List<UserInfoVo> groupUser(Long groupId, Long uid) {
        return  mmcGroupMapper.listGroupUser(groupId,uid);
    }

    @Override
    public GroupUserVo detail(Long groupId, Long id) {
        return mmcGroupMapper.detail(groupId,id);
    }
}
