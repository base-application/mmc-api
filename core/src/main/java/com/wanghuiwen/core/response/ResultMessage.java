package com.wanghuiwen.core.response;

public enum ResultMessage {
    NO_RELATED_USER("没有找到相关用户数据"),
    ;

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
