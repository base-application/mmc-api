package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 分组ID
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 名称
     */
    private String name;

    /**
     * 联系方式
     */
    @Column(name = "concat_number")
    private String concatNumber;

    /**
     * 头像
     */
    private String picture;

    /**
     * 行业
     */
    private String industry;

    /**
     * 国家
     */
    private Integer country;

    /**
     * 州/省
     */
    private Integer state;

    /**
     * 生日
     */
    private Long birthday;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 自我介绍
     */
    private String introduction;

    private String whatsapp;

    private String facebook;

    private String linkedin;

    private String youtube;

    private String instagram;

    /**
     * 级别ID
     */
    @Column(name = "grade_id")
    private Integer gradeId;

    /**
     * Member/Guest
     */
    private String member;

    @Column(name = "position_id")
    private Integer positionId;

    /**
     * email
     */
    private String email;

    private static final long serialVersionUID = 1L;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取分组ID
     *
     * @return group_id - 分组ID
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置分组ID
     *
     * @param groupId 分组ID
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系方式
     *
     * @return concat_number - 联系方式
     */
    public String getConcatNumber() {
        return concatNumber;
    }

    /**
     * 设置联系方式
     *
     * @param concatNumber 联系方式
     */
    public void setConcatNumber(String concatNumber) {
        this.concatNumber = concatNumber;
    }

    /**
     * 获取头像
     *
     * @return picture - 头像
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置头像
     *
     * @param picture 头像
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取行业
     *
     * @return industry - 行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置行业
     *
     * @param industry 行业
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public Integer getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(Integer country) {
        this.country = country;
    }

    /**
     * 获取州/省
     *
     * @return state - 州/省
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置州/省
     *
     * @param state 州/省
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取职业
     *
     * @return occupation - 职业
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 设置职业
     *
     * @param occupation 职业
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * 获取自我介绍
     *
     * @return introduction - 自我介绍
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置自我介绍
     *
     * @param introduction 自我介绍
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return whatsapp
     */
    public String getWhatsapp() {
        return whatsapp;
    }

    /**
     * @param whatsapp
     */
    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    /**
     * @return facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * @return linkedin
     */
    public String getLinkedin() {
        return linkedin;
    }

    /**
     * @param linkedin
     */
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    /**
     * @return youtube
     */
    public String getYoutube() {
        return youtube;
    }

    /**
     * @param youtube
     */
    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    /**
     * @return instagram
     */
    public String getInstagram() {
        return instagram;
    }

    /**
     * @param instagram
     */
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    /**
     * 获取级别ID
     *
     * @return grade_id - 级别ID
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * 设置级别ID
     *
     * @param gradeId 级别ID
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * 获取Member/Guest
     *
     * @return member - Member/Guest
     */
    public String getMember() {
        return member;
    }

    /**
     * 设置Member/Guest
     *
     * @param member Member/Guest
     */
    public void setMember(String member) {
        this.member = member;
    }

    /**
     * @return position_id
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取email
     *
     * @return email - email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}