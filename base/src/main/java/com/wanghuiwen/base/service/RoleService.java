package com.wanghuiwen.base.service;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.vo.RoleApiAdd;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghuiwen on 2021/07/13.
 */
public interface RoleService extends Service<Role> {
    List<Role> getByUser(Long id);

    Result addApi(RoleApiAdd add);

    Result addMenu(RoleApiAdd add);
}
