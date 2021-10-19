package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "slider_grade")
public class SliderGrade implements Serializable {
    @Id
    @Column(name = "slider_id")
    private Integer sliderId;

    @Column(name = "grade_id")
    private Integer gradeId;

    private static final long serialVersionUID = 1L;

    /**
     * @return slider_id
     */
    public Integer getSliderId() {
        return sliderId;
    }

    /**
     * @param sliderId
     */
    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }

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
}