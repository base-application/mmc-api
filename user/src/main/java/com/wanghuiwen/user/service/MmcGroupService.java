package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.GroupUserVo;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface MmcGroupService extends Service<MmcGroup> {
    List<GroupUserVo> listUser();
}
