package com.wanghuiwen.address.vo;


import com.wanghuiwen.address.model.AddressDistrict;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CityVo implements Serializable {
    private Integer id;

    private String name;

    private Integer stateId;

    private String stateCode;

    private Integer countryId;

    private String countryCode;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Boolean flag;

    /**
     * 各国翻译
     */
    private String translations;

    List<AddressDistrict> districtList;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return state_id
     */
    public Integer getStateId() {
        return stateId;
    }

    /**
     * @param stateId
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    /**
     * @return state_code
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * @param stateCode
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * @return country_id
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * @return country_code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * @return flag
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取各国翻译
     *
     * @return translations - 各国翻译
     */
    public String getTranslations() {
        return translations;
    }

    /**
     * 设置各国翻译
     *
     * @param translations 各国翻译
     */
    public void setTranslations(String translations) {
        this.translations = translations;
    }

    public List<AddressDistrict> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<AddressDistrict> districtList) {
        this.districtList = districtList;
    }
}