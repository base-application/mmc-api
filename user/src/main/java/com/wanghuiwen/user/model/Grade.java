package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Grade implements Serializable {
    @Id
    @Column(name = "grade_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;

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
     * @return grade_name
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}