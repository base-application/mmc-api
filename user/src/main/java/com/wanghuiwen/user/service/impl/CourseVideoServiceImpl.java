package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CourseVideoMapper;
import com.wanghuiwen.user.model.CourseVideo;
import com.wanghuiwen.user.service.CourseVideoService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2022/02/19.
 */
@Service
@Transactional
public class CourseVideoServiceImpl extends AbstractService<CourseVideo> implements CourseVideoService {
    @Resource
    private CourseVideoMapper courseVideoMapper;
}
