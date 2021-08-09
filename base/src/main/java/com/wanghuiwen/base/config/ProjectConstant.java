package com.wanghuiwen.base.config;


import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.SysDepartment;

/**
 * 项目常量
 */
public final class ProjectConstant {

    static {
        SysDepartment department1 = new SysDepartment();
        department1.setId(1L);
        department1.setName("总组织");
        department1.setPid(0L);
        department =department1;
    }

    public static final String BASE_PACKAGE = "com.api";//项目基础包名称，根据自己公司的项目修改

    static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
    static final String MAPPER_PACKAGE = BASE_PACKAGE + ".**.dao";//Mapper所在包
    static final String MAPPER_INTERFACE_REFERENCE = "com.wanghuiwen.core.ApiMapper";//Mapper插件基础接口的完全限定名

    public static final String ROLE_ADMIN="管理员";
    public static final String ROLE_USER="user";

    /**
     * 默认角色
     */
    static final Role[] initRole={new Role("管理员"),new Role("普通用户"),new Role("商户")};
    /**
     * 默认部门
     */
    public static SysDepartment department;
    public static final String WHITE_LIST_CACHE_KEY = "white_list";
    public static final String API_LIST_CACHE_KEY = "api_list";
}
