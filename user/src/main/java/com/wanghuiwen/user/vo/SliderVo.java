package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.model.MmcGroup;

import java.util.List;

public class SliderVo {
    private Integer sliderId;
    private String sliderPoster;
    private Long createTime;
    List<MmcGroup> group;
    List<Grade> grades;

    public Integer getSliderId() {
        return sliderId;
    }

    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }

    public String getSliderPoster() {
        return sliderPoster;
    }

    public void setSliderPoster(String sliderPoster) {
        this.sliderPoster = sliderPoster;
    }

    public List<MmcGroup> getGroup() {
        return group;
    }

    public void setGroup(List<MmcGroup> group) {
        this.group = group;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}

