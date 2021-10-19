package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "guide_line")
public class GuideLine implements Serializable {
    @Id
    @Column(name = "guide_line_id")
    private Long guideLineId;

    @Column(name = "guide_line_title")
    private String guideLineTitle;

    @Column(name = "guide_line_image")
    private String guideLineImage;

    private static final long serialVersionUID = 1L;

    /**
     * @return guide_line_id
     */
    public Long getGuideLineId() {
        return guideLineId;
    }

    /**
     * @param guideLineId
     */
    public void setGuideLineId(Long guideLineId) {
        this.guideLineId = guideLineId;
    }

    /**
     * @return guide_line_title
     */
    public String getGuideLineTitle() {
        return guideLineTitle;
    }

    /**
     * @param guideLineTitle
     */
    public void setGuideLineTitle(String guideLineTitle) {
        this.guideLineTitle = guideLineTitle;
    }

    /**
     * @return guide_line_image
     */
    public String getGuideLineImage() {
        return guideLineImage;
    }

    /**
     * @param guideLineImage
     */
    public void setGuideLineImage(String guideLineImage) {
        this.guideLineImage = guideLineImage;
    }
}