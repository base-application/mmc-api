package com.wanghuiwen.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog implements Serializable {
    @Id
    @Column(name = "log_id")
    private Long logId;

    /**
     * 时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 用户
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 模块名称
     */
    private String modular;

    /**
     * 请求路径
     */
    @Column(name = "request_path")
    private String requestPath;

    /**
     * 请求方式
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 请求参数
     */
    @Column(name = "request_params")
    private String requestParams;

    /**
     * 接口名称
     */
    private String method;

    private static final long serialVersionUID = 1L;

    /**
     * @return log_id
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * @param logId
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 获取时间
     *
     * @return create_time - 时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间
     *
     * @param createTime 时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户
     *
     * @return user_id - 用户
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户
     *
     * @param userId 用户
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取模块名称
     *
     * @return modular - 模块名称
     */
    public String getModular() {
        return modular;
    }

    /**
     * 设置模块名称
     *
     * @param modular 模块名称
     */
    public void setModular(String modular) {
        this.modular = modular;
    }

    /**
     * 获取请求路径
     *
     * @return request_path - 请求路径
     */
    public String getRequestPath() {
        return requestPath;
    }

    /**
     * 设置请求路径
     *
     * @param requestPath 请求路径
     */
    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    /**
     * 获取请求方式
     *
     * @return request_method - 请求方式
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * 设置请求方式
     *
     * @param requestMethod 请求方式
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * 获取请求参数
     *
     * @return request_params - 请求参数
     */
    public String getRequestParams() {
        return requestParams;
    }

    /**
     * 设置请求参数
     *
     * @param requestParams 请求参数
     */
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    /**
     * 获取接口名称
     *
     * @return method - 接口名称
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置接口名称
     *
     * @param method 接口名称
     */
    public void setMethod(String method) {
        this.method = method;
    }
}