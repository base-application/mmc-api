package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.AttendanceMapper;
import com.wanghuiwen.user.model.Attendance;
import com.wanghuiwen.user.service.AttendanceService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class AttendanceServiceImpl extends AbstractService<Attendance> implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;
}
