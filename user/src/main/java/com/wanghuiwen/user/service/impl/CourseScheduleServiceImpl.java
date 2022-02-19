package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CourseScheduleMapper;
import com.wanghuiwen.user.model.CourseSchedule;
import com.wanghuiwen.user.service.CourseScheduleService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2022/02/19.
 */
@Service
@Transactional
public class CourseScheduleServiceImpl extends AbstractService<CourseSchedule> implements CourseScheduleService {
    @Resource
    private CourseScheduleMapper courseScheduleMapper;
}
