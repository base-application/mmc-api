package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "thank_you_note_picture")
public class ThankYouNotePicture implements Serializable {
    @Id
    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "note_id")
    private Long noteId;

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
     * @return note_id
     */
    public Long getNoteId() {
        return noteId;
    }

    /**
     * @param noteId
     */
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
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