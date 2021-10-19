package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_company")
public class UserCompany implements Serializable {
    @Id
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "user_id")
    private Long userId;

    /**
     * logo
     */
    @Column(name = "company_logo")
    private String companyLogo;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 网站
     */
    @Column(name = "company_website")
    private String companyWebsite;

    /**
     * 邮件
     */
    @Column(name = "company_email")
    private String companyEmail;

    /**
     * 电话
     */
    @Column(name = "company_phone")
    private String companyPhone;

    /**
     * facebook
     */
    @Column(name = "company_facebook")
    private String companyFacebook;

    /**
     * linkedin
     */
    @Column(name = "company_linkedin")
    private String companyLinkedin;

    /**
     * youtobe
     */
    @Column(name = "company_youtube")
    private String companyYoutube;

    /**
     * instagram
     */
    @Column(name = "company_instagram")
    private String companyInstagram;

    /**
     * 简介
     */
    @Column(name = "company_introduction")
    private String companyIntroduction;

    /**
     * 目标
     */
    @Column(name = "company_goals")
    private String companyGoals;

    /**
     * 成就
     */
    @Column(name = "company_accomplishments")
    private String companyAccomplishments;

    /**
     * 兴趣
     */
    @Column(name = "company_interests")
    private String companyInterests;

    /**
     * 服务简介
     */
    @Column(name = "service_introduction")
    private String serviceIntroduction;

    private static final long serialVersionUID = 1L;

    /**
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

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
     * 获取logo
     *
     * @return company_logo - logo
     */
    public String getCompanyLogo() {
        return companyLogo;
    }

    /**
     * 设置logo
     *
     * @param companyLogo logo
     */
    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取地址
     *
     * @return company_address - 地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置地址
     *
     * @param companyAddress 地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 获取网站
     *
     * @return company_website - 网站
     */
    public String getCompanyWebsite() {
        return companyWebsite;
    }

    /**
     * 设置网站
     *
     * @param companyWebsite 网站
     */
    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    /**
     * 获取邮件
     *
     * @return company_email - 邮件
     */
    public String getCompanyEmail() {
        return companyEmail;
    }

    /**
     * 设置邮件
     *
     * @param companyEmail 邮件
     */
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    /**
     * 获取电话
     *
     * @return company_phone - 电话
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * 设置电话
     *
     * @param companyPhone 电话
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    /**
     * 获取facebook
     *
     * @return company_facebook - facebook
     */
    public String getCompanyFacebook() {
        return companyFacebook;
    }

    /**
     * 设置facebook
     *
     * @param companyFacebook facebook
     */
    public void setCompanyFacebook(String companyFacebook) {
        this.companyFacebook = companyFacebook;
    }

    /**
     * 获取linkedin
     *
     * @return company_linkedin - linkedin
     */
    public String getCompanyLinkedin() {
        return companyLinkedin;
    }

    /**
     * 设置linkedin
     *
     * @param companyLinkedin linkedin
     */
    public void setCompanyLinkedin(String companyLinkedin) {
        this.companyLinkedin = companyLinkedin;
    }

    /**
     * 获取youtobe
     *
     * @return company_youtube - youtobe
     */
    public String getCompanyYoutube() {
        return companyYoutube;
    }

    /**
     * 设置youtobe
     *
     * @param companyYoutube youtobe
     */
    public void setCompanyYoutube(String companyYoutube) {
        this.companyYoutube = companyYoutube;
    }

    /**
     * 获取instagram
     *
     * @return company_instagram - instagram
     */
    public String getCompanyInstagram() {
        return companyInstagram;
    }

    /**
     * 设置instagram
     *
     * @param companyInstagram instagram
     */
    public void setCompanyInstagram(String companyInstagram) {
        this.companyInstagram = companyInstagram;
    }

    /**
     * 获取简介
     *
     * @return company_introduction - 简介
     */
    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    /**
     * 设置简介
     *
     * @param companyIntroduction 简介
     */
    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

    /**
     * 获取目标
     *
     * @return company_goals - 目标
     */
    public String getCompanyGoals() {
        return companyGoals;
    }

    /**
     * 设置目标
     *
     * @param companyGoals 目标
     */
    public void setCompanyGoals(String companyGoals) {
        this.companyGoals = companyGoals;
    }

    /**
     * 获取成就
     *
     * @return company_accomplishments - 成就
     */
    public String getCompanyAccomplishments() {
        return companyAccomplishments;
    }

    /**
     * 设置成就
     *
     * @param companyAccomplishments 成就
     */
    public void setCompanyAccomplishments(String companyAccomplishments) {
        this.companyAccomplishments = companyAccomplishments;
    }

    /**
     * 获取兴趣
     *
     * @return company_interests - 兴趣
     */
    public String getCompanyInterests() {
        return companyInterests;
    }

    /**
     * 设置兴趣
     *
     * @param companyInterests 兴趣
     */
    public void setCompanyInterests(String companyInterests) {
        this.companyInterests = companyInterests;
    }

    /**
     * 获取服务简介
     *
     * @return service_introduction - 服务简介
     */
    public String getServiceIntroduction() {
        return serviceIntroduction;
    }

    /**
     * 设置服务简介
     *
     * @param serviceIntroduction 服务简介
     */
    public void setServiceIntroduction(String serviceIntroduction) {
        this.serviceIntroduction = serviceIntroduction;
    }
}