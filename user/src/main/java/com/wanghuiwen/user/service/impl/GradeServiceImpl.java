package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.GradeMapper;
import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.service.GradeService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class GradeServiceImpl extends AbstractService<Grade> implements GradeService {
    @Resource
    private GradeMapper gradeMapper;

    @Override
    public void deleteByEvent(Long eventId) {
        gradeMapper.deleteByEvent(eventId);
    }
}
