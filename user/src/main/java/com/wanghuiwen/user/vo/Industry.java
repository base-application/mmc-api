package com.wanghuiwen.user.vo;

public class Industry {
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public Industry(String enName, String cnName) {
        this.enName = enName;
        this.cnName = cnName;
    }

    String enName;
    String cnName;
}
