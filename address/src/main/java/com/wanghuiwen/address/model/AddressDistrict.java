package com.wanghuiwen.address.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "address_district")
public class AddressDistrict implements Serializable {
    @Id
    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "district_name")
    private String districtName;

    /**
     * 城市
     */
    @Column(name = "city_id")
    private Integer cityId;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private static final long serialVersionUID = 1L;

    /**
     * @return district_id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * @return district_name
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * 获取城市
     *
     * @return city_id - 城市
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置城市
     *
     * @param cityId 城市
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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
}