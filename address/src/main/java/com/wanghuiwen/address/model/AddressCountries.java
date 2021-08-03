package com.wanghuiwen.address.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "address_countries")
public class AddressCountries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String iso3;

    private String iso2;

    private String phonecode;

    private String capital;

    private String currency;

    @Column(name = "currency_symbol")
    private String currencySymbol;

    private String tld;

    @Column(name = "native")
    private String nativeName;

    private String region;

    private String subregion;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String emoji;

    @Column(name = "emojiU")
    private String emojiu;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    private Boolean flag;

    /**
     * Rapid API GeoDB Cities
     */
    @Column(name = "wikiDataId")
    private String wikidataid;

    @Column(name = "numeric_code")
    private String numericCode;

    private String timezones;

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
     * @return iso3
     */
    public String getIso3() {
        return iso3;
    }

    /**
     * @param iso3
     */
    public void setIso3(String iso3) {
        this.iso3 = iso3;
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
     * @return phonecode
     */
    public String getPhonecode() {
        return phonecode;
    }

    /**
     * @param phonecode
     */
    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    /**
     * @return capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @param capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return currency_symbol
     */
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * @param currencySymbol
     */
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * @return tld
     */
    public String getTld() {
        return tld;
    }

    /**
     * @param tld
     */
    public void setTld(String tld) {
        this.tld = tld;
    }

    /**
     * @return native
     */
    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return subregion
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     * @param subregion
     */
    public void setSubregion(String subregion) {
        this.subregion = subregion;
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
     * @return emoji
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * @param emoji
     */
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    /**
     * @return emojiU
     */
    public String getEmojiu() {
        return emojiu;
    }

    /**
     * @param emojiu
     */
    public void setEmojiu(String emojiu) {
        this.emojiu = emojiu;
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
     * 获取Rapid API GeoDB Cities
     *
     * @return wikiDataId - Rapid API GeoDB Cities
     */
    public String getWikidataid() {
        return wikidataid;
    }

    /**
     * 设置Rapid API GeoDB Cities
     *
     * @param wikidataid Rapid API GeoDB Cities
     */
    public void setWikidataid(String wikidataid) {
        this.wikidataid = wikidataid;
    }

    /**
     * @return numeric_code
     */
    public String getNumericCode() {
        return numericCode;
    }

    /**
     * @param numericCode
     */
    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    /**
     * @return timezones
     */
    public String getTimezones() {
        return timezones;
    }

    /**
     * @param timezones
     */
    public void setTimezones(String timezones) {
        this.timezones = timezones;
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