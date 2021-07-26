package com.wanghuiwen.base.model;

import java.io.Serializable;
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
     * 商户Id
     */
    @Column(name = "merchant_id")
    private Long merchantId;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

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
     * 获取商户Id
     *
     * @return merchant_id - 商户Id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户Id
     *
     * @param merchantId 商户Id
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}