package com.wanghuiwen.user.vo;

import java.math.BigDecimal;
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
    private Integer country;
    private Integer state;
    private Long birthday;
    private String occupation;
    private String introduction;
    private String whatsapp;
    private String facebook;
    private String linkedin;
    private String youtube;
    private String instagram;
    private Integer gradeId;
    private String gradeName;
    private Integer groupId;
    private String groupName;
    private String email;
    private String countryName;
    private String stateName;
    private int attendance;
    private int referralSend;
    private int referralReceived;
    private int thankYouNote;
    private int thankYouNoteSum;
    private boolean enable;

    private Integer positionId;
    private String positionName;
    private String member;
    private Integer referralCount;
    private BigDecimal point;
    private String referralCode;

    List<CompanyVo> companyVos;

    Achievement achievement;

    private Boolean friend;

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

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
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

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Boolean getFriend() {
        return friend;
    }

    public void setFriend(Boolean friend) {
        this.friend = friend;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getThankYouNoteSum() {
        return thankYouNoteSum;
    }

    public void setThankYouNoteSum(int thankYouNoteSum) {
        this.thankYouNoteSum = thankYouNoteSum;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getReferralCount() {
        return referralCount;
    }

    public void setReferralCount(Integer referralCount) {
        this.referralCount = referralCount;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
}
