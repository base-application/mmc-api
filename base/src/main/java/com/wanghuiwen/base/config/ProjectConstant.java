package com.wanghuiwen.base.config;


import com.wanghuiwen.base.model.Role;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.api";//项目基础包名称，根据自己公司的项目修改

    static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
    static final String MAPPER_PACKAGE = BASE_PACKAGE + ".**.dao";//Mapper所在包
    static final String MAPPER_INTERFACE_REFERENCE = "com.wanghuiwen.core.ApiMapper";//Mapper插件基础接口的完全限定名
    public static final String ROLE_ADMIN="admin";
    public static final String ROLE_USER="user";
    static final Role[] initRole={new Role("管理员"),new Role("普通用户")};
}
