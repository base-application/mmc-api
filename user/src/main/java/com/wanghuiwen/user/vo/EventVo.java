package com.wanghuiwen.user.vo;

import java.util.List;

public class EventVo extends EventVoAdd {

    List<AttendanceVo> attendance;

    public List<AttendanceVo> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<AttendanceVo> attendance) {
        this.attendance = attendance;
    }
}
