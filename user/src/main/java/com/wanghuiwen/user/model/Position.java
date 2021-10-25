package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Position implements Serializable {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @Column(name = "position_name")
    private String positionName;

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
}