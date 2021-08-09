package com.wanghuiwen.ecommerce.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.model.Merchant;
import com.wanghuiwen.ecommerce.service.ManagerService;
import com.wanghuiwen.ecommerce.service.MerchantService;
import com.wanghuiwen.ecommerce.vo.ManagerVo;
import com.wanghuiwen.ecommerce.vo.MerchantVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2021/08/03.
 */
@Api(value = "商户管理", tags = {"商户管理"})
@RestController
@RequestMapping("/manager")
public class MerchantController extends Ctrl {
    @Resource
    private ManagerService managerService;
    @Resource
    private MerchantService merchantService;

    @ApiOperation(value = "商铺修改", tags = {"商户管理"}, notes = "notes")
    @PutMapping(value = "/save", name = "保存商户用户")
    public Result save(@RequestBody @Validated Merchant merchant) {
        merchantService.saveOrUpdate(merchant);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "商铺添加", tags = {"商户管理"}, notes = "notes")
    @PostMapping(value = "/add", name = "添加商户用户")
    public Result add(@RequestBody MerchantVo merchant) {
        return merchantService.add(merchant);
    }

    @ApiOperation(value = "商铺列表", tags = {"商户管理"}, notes = "notes")
    @GetMapping(value = "/list", name = "商铺列表")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       String name
    ) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        PageHelper.startPage(page, size);
        List<Merchant> merchants = merchantService.list(params);
        PageInfo<Merchant> pageInfo = new PageInfo<>(merchants);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "商铺添加管理员", tags = {"商户管理"}, notes = "notes")
    @PostMapping(value = "/add/admin", name = "商铺添加管理员")
    public Result addAdmin(@RequestBody ManagerVo manager, Authentication authentication) {
        return managerService.add(manager,getAuthUser(authentication));
    }



    @ApiOperation(value = "商铺管理员", tags = {"商户管理"}, notes = "notes")
    @GetMapping(value = "merchant/admins", name = "商铺管理员")
    public Result adminList(@RequestParam(defaultValue = "0") Integer page,
                            @RequestParam(defaultValue = "10") Integer size,
                            String name,
                            @RequestParam(required = true) Long merchantId) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("merchantId", merchantId);

        PageHelper.startPage(page, size);
        List<ManagerVo> merchants = merchantService.admins(params);
        PageInfo<ManagerVo> pageInfo = new PageInfo<>(merchants);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
