package com.wanghuiwen.user.vo;

import java.util.List;

public class EventVo extends EventVoAdd {

    private List<AttendanceVo> attendance;

    private Double attendanceProportion;

    private Integer approveStatus;

    private Boolean checkIn;

    public List<AttendanceVo> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<AttendanceVo> attendance) {
        this.attendance = attendance;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Double getAttendanceProportion() {
        return attendanceProportion;
    }

    public void setAttendanceProportion(Double attendanceProportion) {
        this.attendanceProportion = attendanceProportion;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }
}
