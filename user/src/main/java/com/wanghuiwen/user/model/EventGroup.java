package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "event_group")
public class EventGroup implements Serializable {
    @Id
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "group_id")
    private Integer groupId;

    private static final long serialVersionUID = 1L;

    /**
     * @return event_id
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * @param eventId
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
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