package com.wanghuiwen.user.service;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface UserInfoService extends Service<UserInfo> {
    List<UserInfoVo> managerList(Integer page, Integer size, Map<String, Object> params);

    void register(User user);

    List<UserNetWorkVo> network(Map<String, Object> params);

    UserInfoVo detail(Long userId, Long id);

    void excelToUser(List<List<String>> excelData);
}
