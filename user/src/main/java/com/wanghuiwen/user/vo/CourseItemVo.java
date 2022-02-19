package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.MasterCourse;

public class CourseItemVo extends MasterCourse {
    private String categoryName;
    private MasterCourse parentCourseDetail;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public MasterCourse getParentCourseDetail() {
        return parentCourseDetail;
    }

    public void setParentCourseDetail(MasterCourse parentCourseDetail) {
        this.parentCourseDetail = parentCourseDetail;
    }
}
