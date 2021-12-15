package com.wanghuiwen.user.service;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.user.vo.*;

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

    UserInfoVo detail(Long userId);

    void excelToUser(List<List<String>> excelData);

    void register(String phoneNumber, String verificationCode, String password, String countryCode);

    String verificationCodeKey(String phoneNumber,Integer type);

    /**
     *
     * @param id
     * @param type 1 当月 2 全部
     * @return
     */
    Achievement achievements(Long id, Integer type);

    List<User> findByGroupAndGrade(List<MmcGroup> groups, List<Grade> grades);

    MessageVo message(Long id);

    int count();

    List<ResultMap<String, Object>> groupByGrade();

    List<ResultMap<String, Object>> mapData();

    List<MapLineVo> mapLine();
}
