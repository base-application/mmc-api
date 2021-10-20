package com.wanghuiwen.user.vo;

import java.util.List;

public class GroupUserVo {
    private Integer groupId;
    private String groupName;
    List<UserInfoVo> userInfoVos;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UserInfoVo> getUserInfoVos() {
        return userInfoVos;
    }

    public void setUserInfoVos(List<UserInfoVo> userInfoVos) {
        this.userInfoVos = userInfoVos;
    }
}
