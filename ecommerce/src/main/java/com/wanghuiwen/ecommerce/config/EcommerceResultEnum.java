package com.wanghuiwen.ecommerce.config;

import com.wanghuiwen.core.response.IResultEnum;

public enum  EcommerceResultEnum implements IResultEnum {
    ONLY_MERCHANT(40001);

    private final int code;

    EcommerceResultEnum(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessageCode() {
        String modeName = "ecommerce";
        return modeName + "." +this.code;
    }


}
