package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.EventGradeMapper;
import com.wanghuiwen.user.model.EventGrade;
import com.wanghuiwen.user.service.EventGradeService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/11/15.
 */
@Service
@Transactional
public class EventGradeServiceImpl extends AbstractService<EventGrade> implements EventGradeService {
    @Resource
    private EventGradeMapper eventGradeMapper;
}
