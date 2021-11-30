package com.wanghuiwen.user.config;

import com.wanghuiwen.core.response.IResultEnum;

public enum UserResultEnum implements IResultEnum {
    VERIFICATION_INVALID(40001),
    VERIFICATION_ERROR(40002),
    OLD_PASSWORD_NOT_MATCH(40006)
    ;

    private final int code;

    UserResultEnum(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessageCode() {
        String modeName = "user";
        return modeName + "." +this.code;
    }


}
