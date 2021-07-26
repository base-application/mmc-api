package com.wanghuiwen.base.vo;

import java.util.List;

public class UserRoleAdd {
    private long userId;
    private List<Long> roles;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}
