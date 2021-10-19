package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "event_picture")
public class EventPicture implements Serializable {
    @Id
    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "event_id")
    private Long eventId;

    private String url;

    private static final long serialVersionUID = 1L;

    /**
     * @return picture_id
     */
    public Long getPictureId() {
        return pictureId;
    }

    /**
     * @param pictureId
     */
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}