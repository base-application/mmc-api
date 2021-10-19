package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Slider implements Serializable {
    @Id
    @Column(name = "slider_id")
    private Integer sliderId;

    @Column(name = "slider_poster")
    private String sliderPoster;

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
     * @return slider_poster
     */
    public String getSliderPoster() {
        return sliderPoster;
    }

    /**
     * @param sliderPoster
     */
    public void setSliderPoster(String sliderPoster) {
        this.sliderPoster = sliderPoster;
    }
}