package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user_follow")
public class UserFollow implements Serializable {
    @Id
    @Column(name = "follow_id")
    private Long followId;

    /**
     * 被关注的人
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 关注的人
     */
    @Column(name = "follow_user_id")
    private Long followUserId;

    private static final long serialVersionUID = 1L;

    /**
     * @return follow_id
     */
    public Long getFollowId() {
        return followId;
    }

    /**
     * @param followId
     */
    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    /**
     * 获取被关注的人
     *
     * @return user_id - 被关注的人
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置被关注的人
     *
     * @param userId 被关注的人
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取关注的人
     *
     * @return follow_user_id - 关注的人
     */
    public Long getFollowUserId() {
        return followUserId;
    }

    /**
     * 设置关注的人
     *
     * @param followUserId 关注的人
     */
    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }
}