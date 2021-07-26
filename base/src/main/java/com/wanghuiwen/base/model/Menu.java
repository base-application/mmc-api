package com.wanghuiwen.base.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路由
     */
    private String path;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 父菜单
     */
    private Long pid;

    /**
     * 图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否隐藏
     */
    private Boolean hidden;

    private String redirect;

    @Column(name = "alwaysShow")
    private String alwaysshow;

    private String meta;

    private List<Menu> children;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单路由
     *
     * @return path - 菜单路由
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置菜单路由
     *
     * @param path 菜单路由
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取排序
     *
     * @return priority - 排序
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置排序
     *
     * @param priority 排序
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取父菜单
     *
     * @return pid - 父菜单
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父菜单
     *
     * @param pid 父菜单
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取图标
     *
     * @return menu_icon - 图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置图标
     *
     * @param menuIcon 图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 获取组件路径
     *
     * @return component - 组件路径
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件路径
     *
     * @param component 组件路径
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取是否隐藏
     *
     * @return hidden - 是否隐藏
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * 设置是否隐藏
     *
     * @param hidden 是否隐藏
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return redirect
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * @param redirect
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * @return alwaysShow
     */
    public String getAlwaysshow() {
        return alwaysshow;
    }

    /**
     * @param alwaysshow
     */
    public void setAlwaysshow(String alwaysshow) {
        this.alwaysshow = alwaysshow;
    }

    /**
     * @return meta
     */
    public String getMeta() {
        return meta;
    }

    /**
     * @param meta
     */
    public void setMeta(String meta) {
        this.meta = meta;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}