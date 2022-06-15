package com.wanghuiwen.base.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登陆名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否禁用
     */
    private Boolean enable;

    /**
     * 过期时间
     */
    @Column(name = "expired_time")
    private Long expiredTime;

    /**
     * 登陆过期
     */
    @Column(name = "credentials_expired_time")
    private Long credentialsExpiredTime;

    /**
     * 是否锁定 /登陆次数限制
     */
    private Boolean locked;

    /**
     * 推送Id
     */
    @Column(name = "push_id")
    private String pushId;

    /**
     * 邀请码
     */
    @Column(name = "referral_code")
    private String referralCode;

    /**
     * 被邀请人
     */
    @Column(name = "referral_id")
    private Long referralId;

    /**
     * 用户积分
     */
    private BigDecimal point;

    /**
     * 邀请人数
     */
    @Column(name = "referral_count")
    private Integer referralCount;

    /**
     * 注册时间
     */
    @Column(name = "registered_time")
    private Long registeredTime;

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
     * 获取登陆名
     *
     * @return login_name - 登陆名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登陆名
     *
     * @param loginName 登陆名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取是否禁用
     *
     * @return enable - 是否禁用
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * 设置是否禁用
     *
     * @param enable 是否禁用
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * 获取过期时间
     *
     * @return expired_time - 过期时间
     */
    public Long getExpiredTime() {
        return expiredTime;
    }

    /**
     * 设置过期时间
     *
     * @param expiredTime 过期时间
     */
    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 获取登陆过期
     *
     * @return credentials_expired_time - 登陆过期
     */
    public Long getCredentialsExpiredTime() {
        return credentialsExpiredTime;
    }

    /**
     * 设置登陆过期
     *
     * @param credentialsExpiredTime 登陆过期
     */
    public void setCredentialsExpiredTime(Long credentialsExpiredTime) {
        this.credentialsExpiredTime = credentialsExpiredTime;
    }

    /**
     * 获取是否锁定 /登陆次数限制
     *
     * @return locked - 是否锁定 /登陆次数限制
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置是否锁定 /登陆次数限制
     *
     * @param locked 是否锁定 /登陆次数限制
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * 获取推送Id
     *
     * @return push_id - 推送Id
     */
    public String getPushId() {
        return pushId;
    }

    /**
     * 设置推送Id
     *
     * @param pushId 推送Id
     */
    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    /**
     * 获取邀请码
     *
     * @return referral_code - 邀请码
     */
    public String getReferralCode() {
        return referralCode;
    }

    /**
     * 设置邀请码
     *
     * @param referralCode 邀请码
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    /**
     * 获取被邀请人
     *
     * @return referral_id - 被邀请人
     */
    public Long getReferralId() {
        return referralId;
    }

    /**
     * 设置被邀请人
     *
     * @param referralId 被邀请人
     */
    public void setReferralId(Long referralId) {
        this.referralId = referralId;
    }

    /**
     * 获取用户积分
     *
     * @return point - 用户积分
     */
    public BigDecimal getPoint() {
        return point;
    }

    /**
     * 设置用户积分
     *
     * @param point 用户积分
     */
    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    /**
     * 获取邀请人数
     *
     * @return referral_count - 邀请人数
     */
    public Integer getReferralCount() {
        return referralCount;
    }

    /**
     * 设置邀请人数
     *
     * @param referralCount 邀请人数
     */
    public void setReferralCount(Integer referralCount) {
        this.referralCount = referralCount;
    }

    /**
     * 获取注册时间
     *
     * @return registered_time - 注册时间
     */
    public Long getRegisteredTime() {
        return registeredTime;
    }

    /**
     * 设置注册时间
     *
     * @param registeredTime 注册时间
     */
    public void setRegisteredTime(Long registeredTime) {
        this.registeredTime = registeredTime;
    }
}