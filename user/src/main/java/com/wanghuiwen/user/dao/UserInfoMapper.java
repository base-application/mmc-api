package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper extends ApiMapper<UserInfo> {
    List<UserInfoVo> managerList(@Param("params") Map<String, Object> params);

    List<UserNetWorkVo> network(Map<String, Object> params);

    UserInfoVo detail(Long userId, Long id);
}