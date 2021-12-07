package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "newset_user_read")
public class NewsetUserRead implements Serializable {
    @Id
    @Column(name = "newest_id")
    private Long newestId;

    @Column(name = "user_id")
    private Long userId;

    private static final long serialVersionUID = 1L;

    /**
     * @return newest_id
     */
    public Long getNewestId() {
        return newestId;
    }

    /**
     * @param newestId
     */
    public void setNewestId(Long newestId) {
        this.newestId = newestId;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}