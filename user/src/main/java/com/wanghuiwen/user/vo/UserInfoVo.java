package com.wanghuiwen.user.vo;

import java.util.List;

public class UserInfoVo {


    /**
     * userId : 1
     * picture : 头像
     * name : 名称
     * concatNumber : 联系方式
     * industry : 行业
     * country : 1
     * state : 1
     * birthday : 1
     * occupation : 职业
     * introduction : 自我介绍
     * whatsapp :
     * facebook :
     * linkedin :
     * youtube :
     * instagram :
     * gradeId : 1
     * gradeName :
     * groupId : 1
     * groupName : 分组名称
     * attendance : 80
     * referralSend : 1
     * referralReceived : 2
     * thankUouNote : 20
     * enable : true
     */

    private Long userId;
    private String picture;
    private String name;
    private String concatNumber;
    private String industry;
    private int country;
    private int state;
    private Long birthday;
    private String occupation;
    private String introduction;
    private String whatsapp;
    private String facebook;
    private String linkedin;
    private String youtube;
    private String instagram;
    private int gradeId;
    private String gradeName;
    private int groupId;
    private String groupName;
    private int attendance;
    private int referralSend;
    private int referralReceived;
    private int thankYouNote;
    private boolean enable;

    private int positionId;
    private String positionName;
    private String member;

    List<CompanyVo> companyVos;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcatNumber() {
        return concatNumber;
    }

    public void setConcatNumber(String concatNumber) {
        this.concatNumber = concatNumber;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getReferralSend() {
        return referralSend;
    }

    public void setReferralSend(int referralSend) {
        this.referralSend = referralSend;
    }

    public int getReferralReceived() {
        return referralReceived;
    }

    public void setReferralReceived(int referralReceived) {
        this.referralReceived = referralReceived;
    }

    public int getThankYouNote() {
        return thankYouNote;
    }

    public void setThankYouNote(int thankYouNote) {
        this.thankYouNote = thankYouNote;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<CompanyVo> getCompanyVos() {
        return companyVos;
    }

    public void setCompanyVos(List<CompanyVo> companyVos) {
        this.companyVos = companyVos;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
