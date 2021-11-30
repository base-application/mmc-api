package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Attendance;
import com.wanghuiwen.user.vo.CheckLogVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceMapper extends ApiMapper<Attendance> {
    Attendance selectUserEvent(Long userId, Long eventId);

    void updateUserEvent(Attendance attendance);

    void deleteUserEvent(Long eventId, Long userId);

    List<CheckLogVo> checkHistory(Long id);
}