package com.wanghuiwen.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "referral_point_log")
public class ReferralPointLog implements Serializable {
    @Id
    @Column(name = "referral_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referralLogId;

    /**
     * 被邀请人
     */
    @Column(name = "costomer_id")
    private Long costomerId;

    /**
     * 邀请人
     */
    @Column(name = "foo_id")
    private Long fooId;

    /**
     * 被邀请人受益
     */
    @Column(name = "costomer_point")
    private BigDecimal costomerPoint;

    /**
     * 邀请人收益
     */
    @Column(name = "foo_point")
    private BigDecimal fooPoint;

    /**
     * 确认时间
     */
    @Column(name = "create_time")
    private Long createTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return referral_log_id
     */
    public Long getReferralLogId() {
        return referralLogId;
    }

    /**
     * @param referralLogId
     */
    public void setReferralLogId(Long referralLogId) {
        this.referralLogId = referralLogId;
    }

    /**
     * 获取被邀请人
     *
     * @return costomer_id - 被邀请人
     */
    public Long getCostomerId() {
        return costomerId;
    }

    /**
     * 设置被邀请人
     *
     * @param costomerId 被邀请人
     */
    public void setCostomerId(Long costomerId) {
        this.costomerId = costomerId;
    }

    /**
     * 获取邀请人
     *
     * @return foo_id - 邀请人
     */
    public Long getFooId() {
        return fooId;
    }

    /**
     * 设置邀请人
     *
     * @param fooId 邀请人
     */
    public void setFooId(Long fooId) {
        this.fooId = fooId;
    }

    /**
     * 获取被邀请人受益
     *
     * @return costomer_point - 被邀请人受益
     */
    public BigDecimal getCostomerPoint() {
        return costomerPoint;
    }

    /**
     * 设置被邀请人受益
     *
     * @param costomerPoint 被邀请人受益
     */
    public void setCostomerPoint(BigDecimal costomerPoint) {
        this.costomerPoint = costomerPoint;
    }

    /**
     * 获取邀请人收益
     *
     * @return foo_point - 邀请人收益
     */
    public BigDecimal getFooPoint() {
        return fooPoint;
    }

    /**
     * 设置邀请人收益
     *
     * @param fooPoint 邀请人收益
     */
    public void setFooPoint(BigDecimal fooPoint) {
        this.fooPoint = fooPoint;
    }

    /**
     * 获取确认时间
     *
     * @return create_time - 确认时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置确认时间
     *
     * @param createTime 确认时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}