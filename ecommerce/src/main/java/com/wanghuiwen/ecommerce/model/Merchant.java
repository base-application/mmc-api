package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Merchant implements Serializable {
    /**
     * 店铺id
     */
    @Id
    @Column(name = "merchant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "param.notnull")
    private Long merchantId;

    /**
     * 名称
     */
    @NotNull(message = "param.notnull")
    private String name;

    /**
     * 头像
     */
    private String logo;

    /**
     * 是否营业
     */
    private Byte business;

    /**
     * 联系电话
     */
    @Column(name = "merchant_contact")
    private String merchantContact;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 地址
     */
    private String address;

    /**
     * 管理员Id
     */
    @Column(name = "manager_id")
    private Long managerId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取店铺id
     *
     * @return merchant_id - 店铺id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置店铺id
     *
     * @param merchantId 店铺id
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
     * 获取头像
     *
     * @return logo - 头像
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置头像
     *
     * @param logo 头像
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取是否营业
     *
     * @return business - 是否营业
     */
    public Byte getBusiness() {
        return business;
    }

    /**
     * 设置是否营业
     *
     * @param business 是否营业
     */
    public void setBusiness(Byte business) {
        this.business = business;
    }

    /**
     * 获取联系电话
     *
     * @return merchant_contact - 联系电话
     */
    public String getMerchantContact() {
        return merchantContact;
    }

    /**
     * 设置联系电话
     *
     * @param merchantContact 联系电话
     */
    public void setMerchantContact(String merchantContact) {
        this.merchantContact = merchantContact;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return area - 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区
     *
     * @param area 区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取管理员Id
     *
     * @return manager_id - 管理员Id
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * 设置管理员Id
     *
     * @param managerId 管理员Id
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}