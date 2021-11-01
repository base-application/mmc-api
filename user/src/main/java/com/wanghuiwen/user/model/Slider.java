package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Slider implements Serializable {
    @Id
    @Column(name = "slider_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sliderId;

    @Column(name = "slider_poster")
    private String sliderPoster;

    @Column(name = "create_time")
    private Long createTime;

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