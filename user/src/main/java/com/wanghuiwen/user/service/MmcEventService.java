package com.wanghuiwen.user.service;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.user.model.CheckLog;
import com.wanghuiwen.user.model.MmcEvent;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.user.vo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface MmcEventService extends Service<MmcEvent> {
    Long add(EventVoAdd add);

    void approve(Long eventId, Integer approveStatus);

    EventVo detail(Long id, Long uid);

    List<EventVoAdd> list(Map<String, Object> params);

    void checkinConfirm(Long userId, Long eventId, Boolean isAttendance);

    void checkin(Long eventId, Long id);

    void join(Long eventId, Long id);

    void unjoin(Long eventId, Long id);

    void checkout(Long eventId, Long id);

    void confirmAttend(Long eventId, Long userId, String agent, String agentRole, String absentReason);

    List<CheckLogVo> checkHistory(Long id);

    void facebookComment(Long eventId, Long userId, Boolean facebookComment);

    List<EventVoAdd> upcomingEvent(AuthUser authentication);

    List<EventVoAdd> joinList(AuthUser authUser);

    List<EventVoAdd> userCreate(AuthUser authUser, Map<String, Object> params);

    List<AttendanceVo> getAttendance(Long id, Long groupId, Long startTime, Long endTime);

    /**
     * 今天后的
     * @return
     */
    List<MmcEvent> findByStartDate();

    List<EventVoAdd> listUser(Map<String, Object> params);

    int count();
}
