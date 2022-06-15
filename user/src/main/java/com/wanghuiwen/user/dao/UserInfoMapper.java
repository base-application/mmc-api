package com.wanghuiwen.user.dao;

import com.wanghuiwen.base.model.User;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.user.vo.Achievement;
import com.wanghuiwen.user.vo.MapLineVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper extends ApiMapper<UserInfo> {
    List<UserInfoVo> managerList(@Param("params") Map<String, Object> params);

    List<UserNetWorkVo> network(@Param("params")Map<String, Object> params);

    UserInfoVo detail(Long userId, Long id);

    UserInfoVo detailUser(Long userId);

    Achievement achievements(Long id, Integer type);

    List<User> findByGroupAndGrade(@Param("groups")List<MmcGroup> groups, @Param("grades")List<Grade> grades);

    List<ResultMap<String, Object>> groupByGrade();

    List<ResultMap<String, Object>> mapData();

    List<MapLineVo> mapLine();

    List<ResultMap<String,Object>> referralList(Long userId);
}