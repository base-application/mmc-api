package com.wanghuiwen.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "role_api")
public class RoleApi implements Serializable {
    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "api_id")
    private Long apiId;

    private static final long serialVersionUID = 1L;

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return api_id
     */
    public Long getApiId() {
        return apiId;
    }

    /**
     * @param apiId
     */
    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }
}