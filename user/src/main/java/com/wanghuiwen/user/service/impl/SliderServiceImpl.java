package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.SliderGradeMapper;
import com.wanghuiwen.user.dao.SliderGroupMapper;
import com.wanghuiwen.user.dao.SliderMapper;
import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.model.Slider;
import com.wanghuiwen.user.model.SliderGrade;
import com.wanghuiwen.user.model.SliderGroup;
import com.wanghuiwen.user.service.SliderService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.SliderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class SliderServiceImpl extends AbstractService<Slider> implements SliderService {
    @Resource
    private SliderMapper sliderMapper;
    @Resource
    private SliderGradeMapper sliderGradeMapper;
    @Resource
    private SliderGroupMapper sliderGroupMapper;

    @Override
    public void add(SliderVo slider) {

        Slider mode = new Slider();
        BeanUtils.copyProperties(slider,mode);
        if(mode.getSliderId()==null){
            mode.setCreateTime(new Date().getTime());
        }
        saveOrUpdate(mode);

        sliderGradeMapper.deleteBySlider(mode.getSliderId());
        sliderGroupMapper.deleteBySlider(mode.getSliderId());

        List<SliderGrade> gradeList = slider.getGrades().stream().map(sg -> {
            SliderGrade grade = new SliderGrade();
            grade.setGradeId(sg.getGradeId());
            grade.setSliderId(mode.getSliderId());
            return grade;
        }).collect(Collectors.toList());

        sliderGradeMapper.insertListNoAuto(gradeList);

        List<SliderGroup> groups = slider.getGroup().stream().map(sg->{
            SliderGroup group = new SliderGroup();
            group.setGroupId(sg.getGroupId());
            group.setSliderId(mode.getSliderId());
            return group;
        }).collect(Collectors.toList());
        sliderGroupMapper.insertListNoAuto(groups);
    }

    @Override
    public List<SliderVo> list() {
        return sliderMapper.list();
    }

    @Override
    public List<SliderVo> userList(Long userId) {

        return sliderMapper.userList(userId);
    }
}
