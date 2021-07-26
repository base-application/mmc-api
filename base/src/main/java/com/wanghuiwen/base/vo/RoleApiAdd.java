package com.wanghuiwen.base.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RoleApiAdd {
    private long roleId;
    @NotEmpty(message = "参数不能为空")
    private List<Long> api;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getApi() {
        return api;
    }

    public void setApi(List<Long> api) {
        this.api = api;
    }
}
