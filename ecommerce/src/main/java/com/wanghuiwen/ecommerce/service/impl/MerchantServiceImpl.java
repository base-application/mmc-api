package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.base.dao.UserMapper;
import com.wanghuiwen.base.model.Role;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.model.UserRole;
import com.wanghuiwen.base.service.RoleService;
import com.wanghuiwen.base.service.UserRoleService;
import com.wanghuiwen.base.service.impl.UserRoleServiceImpl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import com.wanghuiwen.ecommerce.dao.ManagerMapper;
import com.wanghuiwen.ecommerce.dao.MerchantMapper;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.model.Merchant;
import com.wanghuiwen.ecommerce.service.MerchantService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.ecommerce.vo.MerchantVo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/08/03.
 */
@Service
@Transactional
public class MerchantServiceImpl extends AbstractService<Merchant> implements MerchantService {
    @Resource
    private MerchantMapper merchantMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ManagerMapper managerMapper;
    @Resource
    private ResultGenerator resultGenerator;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;

    @Override
    public Result add(MerchantVo merchant) {

        User user = new User();
        user.setAvatar(merchant.getAvatar());
        user.setLocked(false);
        user.setEnable(true);
        user.setExpiredTime(DateUtils.addDays(new Date(),365).getTime());
        user.setLoginName(merchant.getLoginName());
        user.setNickName(merchant.getNickName());
        user.setPassword(new BCryptPasswordEncoder().encode(merchant.getPassword()));
        userMapper.insert(user);

        UserRole role = new UserRole();
        role.setUserId(user.getId());
        Role storeAdmin= roleService.findBy("name", "商户");
        role.setRoleId(storeAdmin.getId());
        userRoleService.save(role);

        Manager manager = new Manager();
        manager.setAvatar(merchant.getAvatar());
        manager.setName(merchant.getName());
        manager.setUserId(user.getId());
        managerMapper.insert(manager);

        Merchant aMerchant = new Merchant();
        aMerchant.setName(merchant.getName());
        aMerchant.setMerchantContact(merchant.getMerchantContact());
        aMerchant.setBusiness(merchant.getBusiness());
        aMerchant.setCreateTime(new Date().getTime());
        aMerchant.setManagerId(manager.getUserId());
        aMerchant.setAddress(merchant.getAddress());
        aMerchant.setLogo(merchant.getLogo());
        merchantMapper.insert(aMerchant);

        manager.setMerchantId(aMerchant.getMerchantId());
        managerMapper.updateByPrimaryKey(manager);

        return resultGenerator.genSuccessResult();
    }

    @Override
    public List<Merchant> list(Map<String, Object> params) {
        return merchantMapper.list(params);
    }

    @Override
    public List<Manager> admins(Map<String, Object> params) {
        return merchantMapper.admins(params);
    }
}
