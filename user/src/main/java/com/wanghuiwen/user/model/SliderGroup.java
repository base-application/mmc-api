package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "slider_group")
public class SliderGroup implements Serializable {
    @Id
    @Column(name = "slider_id")
    private Integer sliderId;

    @Column(name = "group_id")
    private Integer groupId;

    private static final long serialVersionUID = 1L;

    /**
     * @return slider_id
     */
    public Integer getSliderId() {
        return sliderId;
    }

    /**
     * @param sliderId
     */
    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }

    /**
     * @return group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}