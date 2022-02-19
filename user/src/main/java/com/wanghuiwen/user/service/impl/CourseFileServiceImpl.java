package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CourseFileMapper;
import com.wanghuiwen.user.model.CourseFile;
import com.wanghuiwen.user.service.CourseFileService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2022/02/19.
 */
@Service
@Transactional
public class CourseFileServiceImpl extends AbstractService<CourseFile> implements CourseFileService {
    @Resource
    private CourseFileMapper courseFileMapper;
}
