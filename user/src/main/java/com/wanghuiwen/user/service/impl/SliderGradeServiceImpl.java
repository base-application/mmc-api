package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.SliderGradeMapper;
import com.wanghuiwen.user.model.SliderGrade;
import com.wanghuiwen.user.service.SliderGradeService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class SliderGradeServiceImpl extends AbstractService<SliderGrade> implements SliderGradeService {
    @Resource
    private SliderGradeMapper sliderGradeMapper;
}
