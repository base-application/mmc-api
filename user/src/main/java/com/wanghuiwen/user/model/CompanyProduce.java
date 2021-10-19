package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "company_produce")
public class CompanyProduce implements Serializable {
    @Id
    @Column(name = "produce_id")
    private Long produceId;

    /**
     * 服务图片
     */
    @Column(name = "produce_picture")
    private String producePicture;

    @Column(name = "company_id")
    private Long companyId;

    private static final long serialVersionUID = 1L;

    /**
     * @return produce_id
     */
    public Long getProduceId() {
        return produceId;
    }

    /**
     * @param produceId
     */
    public void setProduceId(Long produceId) {
        this.produceId = produceId;
    }

    /**
     * 获取服务图片
     *
     * @return produce_picture - 服务图片
     */
    public String getProducePicture() {
        return producePicture;
    }

    /**
     * 设置服务图片
     *
     * @param producePicture 服务图片
     */
    public void setProducePicture(String producePicture) {
        this.producePicture = producePicture;
    }

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
}