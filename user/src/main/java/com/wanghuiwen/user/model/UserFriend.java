package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_friend")
public class UserFriend implements Serializable {
    @Id
    @Column(name = "fans_id")
    private Long fansId;

    @Column(name = "idol_id")
    private Long idolId;

    @Column(name = "create_time")
    private Long createTime;

    private static final long serialVersionUID = 1L;

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
}