package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_friend_apply")
public class UserFriendApply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fans_id")
    private Long fansId;

    @Column(name = "idol_id")
    private Long idolId;

    @Column(name = "create_time")
    private Long createTime;

    /**
     * 1 等待处理 2 同意 3 拒绝
     */
    private Integer state;

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
     * @return fans_id
     */
    public Long getFansId() {
        return fansId;
    }

    /**
     * @param fansId
     */
    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    /**
     * @return idol_id
     */
    public Long getIdolId() {
        return idolId;
    }

    /**
     * @param idolId
     */
    public void setIdolId(Long idolId) {
        this.idolId = idolId;
    }

    /**
     * @return create_time
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取1 等待处理 2 同意 3 拒绝
     *
     * @return state - 1 等待处理 2 同意 3 拒绝
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1 等待处理 2 同意 3 拒绝
     *
     * @param state 1 等待处理 2 同意 3 拒绝
     */
    public void setState(Integer state) {
        this.state = state;
    }
}