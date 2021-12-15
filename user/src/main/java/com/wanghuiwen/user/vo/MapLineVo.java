package com.wanghuiwen.user.vo;

import java.math.BigDecimal;

public class MapLineVo {
    private BigDecimal formLat;
    private BigDecimal formLog;
    private BigDecimal toLat;
    private BigDecimal toLog;
    private String name;

    public BigDecimal getFormLat() {
        return formLat;
    }

    public void setFormLat(BigDecimal formLat) {
        this.formLat = formLat;
    }

    public BigDecimal getFormLog() {
        return formLog;
    }

    public void setFormLog(BigDecimal formLog) {
        this.formLog = formLog;
    }

    public BigDecimal getToLat() {
        return toLat;
    }

    public void setToLat(BigDecimal toLat) {
        this.toLat = toLat;
    }

    public BigDecimal getToLog() {
        return toLog;
    }

    public void setToLog(BigDecimal toLog) {
        this.toLog = toLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
