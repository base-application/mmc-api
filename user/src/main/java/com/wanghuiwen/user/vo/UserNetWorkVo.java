package com.wanghuiwen.user.vo;

public class UserNetWorkVo {


    /**
     * userId : 1
     * picture : 头像
     * groupId : 1
     * name : 名称
     * concatNumber : 联系方式
     * industry : 行业
     * country : 国家
     * state : 州/省
     * birthday : 2021-10-13
     * occupation : 职业
     * introduction : 自我介绍
     * whatsapp :
     * facebook :
     * linkedin :
     * youtube :
     * instagram :
     * gradeId : 1
     * attendance : 80
     * referralSend : 1
     * referralReceived : 2
     * thankUouNote : 20
     * enable : true
     * isFriend : true
     */

    private Long userId;
    private String picture;
    private int groupId;
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
    private Double attendance;
    private int referralSend;
    private int referralReceived;
    private int thankUouNote;
    private boolean enable;
    private boolean isFriend;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
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

    public int getThankUouNote() {
        return thankUouNote;
    }

    public void setThankUouNote(int thankUouNote) {
        this.thankUouNote = thankUouNote;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }
}
