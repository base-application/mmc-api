package com.wanghuiwen.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_grade")
public class UserGrade implements Serializable {
    @Id
    @Column(name = "grade_id")
    private Integer gradeId;

    /**
     * 等级名称
     */
    @Column(name = "grade_name")
    private String gradeName;

    private static final long serialVersionUID = 1L;

    /**
     * @return grade_id
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * @param gradeId
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * 获取等级名称
     *
     * @return grade_name - 等级名称
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * 设置等级名称
     *
     * @param gradeName 等级名称
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}