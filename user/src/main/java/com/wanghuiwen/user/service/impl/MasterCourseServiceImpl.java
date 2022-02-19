package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.MasterCourseMapper;
import com.wanghuiwen.user.model.MasterCourse;
import com.wanghuiwen.user.service.MasterCourseService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2022/02/19.
 */
@Service
@Transactional
public class MasterCourseServiceImpl extends AbstractService<MasterCourse> implements MasterCourseService {
    @Resource
    private MasterCourseMapper masterCourseMapper;
}
