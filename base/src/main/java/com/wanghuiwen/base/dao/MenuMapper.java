package com.wanghuiwen.base.dao;

import com.wanghuiwen.base.model.Menu;
import com.wanghuiwen.core.ApiMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends ApiMapper<Menu> {
    List<Menu> getByUid(Long userId);

    List<Menu> getByRole(Long roleId);
}