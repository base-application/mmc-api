package com.wanghuiwen.address.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "address_states")
public class AddressStates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "fips_code")
    private String fipsCode;

    private String iso2;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    private Boolean flag;

    @Column(name = "wikiDataId")
    private String wikidataid;

    /**
     * 各国翻译
     */
    private String translations;

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
     * @return fips_code
     */
    public String getFipsCode() {
        return fipsCode;
    }

    /**
     * @param fipsCode
     */
    public void setFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
    }

    /**
     * @return iso2
     */
    public String getIso2() {
        return iso2;
    }

    /**
     * @param iso2
     */
    public void setIso2(String iso2) {
        this.iso2 = iso2;
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
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
     * @return wikiDataId
     */
    public String getWikidataid() {
        return wikidataid;
    }

    /**
     * @param wikidataid
     */
    public void setWikidataid(String wikidataid) {
        this.wikidataid = wikidataid;
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
}