package com.wanghuiwen.user.service;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.user.model.MmcEvent;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.user.vo.CheckHistoryVo;
import com.wanghuiwen.user.vo.EventVo;
import com.wanghuiwen.user.vo.EventVoAdd;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface MmcEventService extends Service<MmcEvent> {
    void add(EventVoAdd add);

    void approve(Long eventId, Integer approveStatus);

    EventVo detail(Integer id);

    List<EventVoAdd> list(Map<String, Object> params);

    void checkinConfirm(Long userId, Long eventId, Boolean isAttendance);

    void checkin(Long eventId, Long id);

    void join(Long eventId, Long id);

    void unjoin(Long eventId, Long id);

    void checkout(Long eventId, Long id);

    void confirmAttend(Long eventId, Long userId, String agent, String agentRole, String absentReason);

    List<CheckHistoryVo> checkHistory(Long id);

    void facebookComment(Long eventId, Long userId, Boolean facebookComment);

    List<EventVoAdd> upcomingEvent(AuthUser authentication);

    List<EventVoAdd> joinList(AuthUser authUser);

    List<EventVoAdd> userCreate(AuthUser authUser);
}
