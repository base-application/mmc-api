package com.wanghuiwen.base.vo;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class UserRoleAdd {
    @NotEmpty(message = "params.not.empty")
    private long userId;
    @NotEmpty(message = "params.not.empty")
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
