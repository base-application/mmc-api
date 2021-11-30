package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.user.vo.GroupUserVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface MmcGroupService extends Service<MmcGroup> {
    List<GroupUserVo> listUser(Long uid, String groupName);

    List<UserInfoVo> groupUser(Long groupId, Long uid);

    GroupUserVo detail(Long groupId, Long id);
}
