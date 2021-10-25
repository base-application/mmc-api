package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.vo.GroupUserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MmcGroupMapper extends ApiMapper<MmcGroup> {
    List<GroupUserVo> listUser();

    MmcGroup findByName(String name);
}