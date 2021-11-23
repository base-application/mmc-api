package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.CompanyProduce;

import javax.persistence.Column;
import java.util.List;

public class CompanyVo {


    /**
     * companyId : 1
     * userId : 1
     * companyLogo : logo
     * companyName : 公司名称
     * companyAddress : 地址
     * companyWebsite : 网站
     * companyEmail : 邮件
     * companyPhone : 电话
     * companyFacebook : facebook
     * companyLinkedin : linkedin
     * companyYoutube : youtobe
     * companyInstagram : instagram
     * companyIntroduction : 简介
     * companyGoals : 目标
     * companyAccomplishments : 成就
     * companyInterests : 兴趣
     * serviceIntroduction : 服务简介
     * producePictures : [{"produceId":1,"producePicture":"服务图片","companyId":1}]
     */

    private Long companyId;
    private Long userId;
    private String companyLogo;
    private String companyName;
    private String companyAddress;
    private String companyWebsite;
    private String companyEmail;
    private String companyPhone;
    private String companyFacebook;
    private String companyLinkedin;
    private String companyYoutube;
    private String companyInstagram;
    private String companyIntroduction;
    private String companyGoals;
    private String companyAccomplishments;
    private String companyInterests;
    private String serviceIntroduction;
    private String city;
    private String postCode;
    private String companyWhatsapp;
    private List<CompanyProduce> producePictures;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFacebook() {
        return companyFacebook;
    }

    public void setCompanyFacebook(String companyFacebook) {
        this.companyFacebook = companyFacebook;
    }

    public String getCompanyLinkedin() {
        return companyLinkedin;
    }

    public void setCompanyLinkedin(String companyLinkedin) {
        this.companyLinkedin = companyLinkedin;
    }

    public String getCompanyYoutube() {
        return companyYoutube;
    }

    public void setCompanyYoutube(String companyYoutube) {
        this.companyYoutube = companyYoutube;
    }

    public String getCompanyInstagram() {
        return companyInstagram;
    }

    public void setCompanyInstagram(String companyInstagram) {
        this.companyInstagram = companyInstagram;
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

    public String getCompanyGoals() {
        return companyGoals;
    }

    public void setCompanyGoals(String companyGoals) {
        this.companyGoals = companyGoals;
    }

    public String getCompanyAccomplishments() {
        return companyAccomplishments;
    }

    public void setCompanyAccomplishments(String companyAccomplishments) {
        this.companyAccomplishments = companyAccomplishments;
    }

    public String getCompanyInterests() {
        return companyInterests;
    }

    public void setCompanyInterests(String companyInterests) {
        this.companyInterests = companyInterests;
    }

    public String getServiceIntroduction() {
        return serviceIntroduction;
    }

    public void setServiceIntroduction(String serviceIntroduction) {
        this.serviceIntroduction = serviceIntroduction;
    }

    public List<CompanyProduce> getProducePictures() {
        return producePictures;
    }

    public void setProducePictures(List<CompanyProduce> producePictures) {
        this.producePictures = producePictures;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCompanyWhatsapp() {
        return companyWhatsapp;
    }

    public void setCompanyWhatsapp(String companyWhatsapp) {
        this.companyWhatsapp = companyWhatsapp;
    }
}
