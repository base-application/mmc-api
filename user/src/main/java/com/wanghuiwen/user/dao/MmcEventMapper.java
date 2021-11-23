package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.MmcEvent;
import com.wanghuiwen.user.vo.AttendanceVo;
import com.wanghuiwen.user.vo.EventVo;
import com.wanghuiwen.user.vo.EventVoAdd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MmcEventMapper extends ApiMapper<MmcEvent> {
    EventVo detail(Long id, Long uid);

    List<EventVoAdd> list(@Param("params") Map<String, Object> params);

    List<EventVoAdd> upcomingEvent(Long id);

    List<EventVoAdd> joinList(Long id);

    List<EventVoAdd> userCreate(Long id, @Param("params") Map<String, Object> params);

    List<AttendanceVo> getAttendance(Long id,Long groupId,Long startTime,Long endTime);

    List<MmcEvent> findByStartDate();
}