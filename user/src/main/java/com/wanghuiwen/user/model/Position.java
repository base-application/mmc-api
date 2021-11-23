package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Position implements Serializable {
    @Id
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name")
    private String positionName;

    /**
     * 是否能新建活动
     */
    @Column(name = "create_event")
    private Boolean createEvent;

    private static final long serialVersionUID = 1L;

    /**
     * @return position_id
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * @return position_name
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * @param positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * 获取是否能新建活动
     *
     * @return create_event - 是否能新建活动
     */
    public Boolean getCreateEvent() {
        return createEvent;
    }

    /**
     * 设置是否能新建活动
     *
     * @param createEvent 是否能新建活动
     */
    public void setCreateEvent(Boolean createEvent) {
        this.createEvent = createEvent;
    }
}