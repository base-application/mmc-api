package com.wanghuiwen.base.model;

import java.io.Serializable;
import javax.persistence.*;

public class Api implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口路径
     */
    private String url;

    /**
     * 接口请求方法
     */
    private String method;

    /**
     * 业务模块
     */
    private String module;

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
     * 获取接口名称
     *
     * @return name - 接口名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置接口名称
     *
     * @param name 接口名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取接口路径
     *
     * @return url - 接口路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置接口路径
     *
     * @param url 接口路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取接口请求方法
     *
     * @return method - 接口请求方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置接口请求方法
     *
     * @param method 接口请求方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取业务模块
     *
     * @return module - 业务模块
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置业务模块
     *
     * @param module 业务模块
     */
    public void setModule(String module) {
        this.module = module;
    }
}