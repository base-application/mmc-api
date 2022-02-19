package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "master_course")
public class MasterCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_photo")
    private String coursePhoto;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "parent_course")
    private Long parentCourse;

    @Column(name = "course_category")
    private Long courseCategory;

    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "concat_us")
    private String concatUs;

    @Column(name = "course_serial")
    private Integer courseSerial;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return course_photo
     */
    public String getCoursePhoto() {
        return coursePhoto;
    }

    /**
     * @param coursePhoto
     */
    public void setCoursePhoto(String coursePhoto) {
        this.coursePhoto = coursePhoto;
    }

    /**
     * @return course_name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return parent_course
     */
    public Long getParentCourse() {
        return parentCourse;
    }

    /**
     * @param parentCourse
     */
    public void setParentCourse(Long parentCourse) {
        this.parentCourse = parentCourse;
    }

    /**
     * @return course_category
     */
    public Long getCourseCategory() {
        return courseCategory;
    }

    /**
     * @param courseCategory
     */
    public void setCourseCategory(Long courseCategory) {
        this.courseCategory = courseCategory;
    }

    /**
     * @return course_description
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * @param courseDescription
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    /**
     * @return concat_us
     */
    public String getConcatUs() {
        return concatUs;
    }

    /**
     * @param concatUs
     */
    public void setConcatUs(String concatUs) {
        this.concatUs = concatUs;
    }

    /**
     * @return course_serial
     */
    public Integer getCourseSerial() {
        return courseSerial;
    }

    /**
     * @param courseSerial
     */
    public void setCourseSerial(Integer courseSerial) {
        this.courseSerial = courseSerial;
    }
}