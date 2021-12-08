package com.wanghuiwen.user.dao;

import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.vo.GroupUserVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MmcGroupMapper extends ApiMapper<MmcGroup> {
    List<GroupUserVo> listUser(Long uid, String groupName);

    MmcGroup findByName(String name);

    List<UserInfoVo> listGroupUser(Long groupId, Long uid);

    GroupUserVo detail(Long groupId, Long uid);

    List<ResultMap<String, Object>> groupRank();
}