package com.wanghuiwen.user.vo;


import com.wanghuiwen.user.model.MasterCourse;

import java.util.List;

public class AppMasterCourseItemVo {
    private Long categoryId;

    private String categoryName;

    private Integer categorySerial;

    private Long createTime;

    List<MasterCourse> courses;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategorySerial() {
        return categorySerial;
    }

    public void setCategorySerial(Integer categorySerial) {
        this.categorySerial = categorySerial;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public List<MasterCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<MasterCourse> courses) {
        this.courses = courses;
    }
}
