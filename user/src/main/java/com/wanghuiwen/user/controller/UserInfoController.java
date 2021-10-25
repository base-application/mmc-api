package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.common.UtilFun;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.model.UserInfo;
import com.wanghuiwen.user.service.PositionService;
import com.wanghuiwen.user.service.UserCompanyService;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.CompanyVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
import io.swagger.annotations.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.wanghuiwen.user.config.UserResultEnum.VERIFICATION_ERROR;
import static com.wanghuiwen.user.config.UserResultEnum.VERIFICATION_INVALID;


/**
* Created by wanghuiwen on 2021/10/18.
*/
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("/user/info")
public class UserInfoController extends Ctrl{
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserCompanyService userCompanyService;
    @Resource
    private UserService userService;
    @Resource
    private PositionService positionService;
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @ApiOperation(value = "用户注册", tags = {"用户管理"}, notes = "用户注册")
    @PostMapping("register")
    public Result register(String phoneNumber,String verificationCode,String password){
        String key = verificationCodeKey(phoneNumber, Const.VERIFICATION_REGISTER);
        String code = redisTemplate.opsForValue().get(key);
        if(code == null){
            return resultGenerator.genFailResult(VERIFICATION_INVALID);
        }
        password = new BCryptPasswordEncoder().encode(password);

        User user = new User();
        user.setPassword(password);
        user.setLoginName(phoneNumber);
        user.setEnable(true);
        user.setLocked(false);

        userInfoService.register(user);

        redisTemplate.delete(key);

        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "发送验证码", tags = {"用户管理"}, notes = "发送验证码")
    @PostMapping("send/verification")
    public Result sendVerification(String phoneNumber,Integer type){
        String key = verificationCodeKey(phoneNumber,type);

        String code = redisTemplate.opsForValue().get(key);
        if(code!=null) return  resultGenerator.genSuccessResult();

        String verificationCode =  UtilFun.getNumRandom(4);
        //5分钟有效时间
        redisTemplate.opsForValue().set(key, verificationCode, 5,TimeUnit.MINUTES);
        //todo 发送短信

        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "修改用户公司信息", tags = {"用户管理"}, notes = "修改用户公司信息")
    @PutMapping("company/update")
    public Result companyUpdate(CompanyVo companyVo){
        userCompanyService.companyUpdate(companyVo);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "删除用户公司信息", tags = {"用户管理"}, notes = "删除用户公司信息")
    @DeleteMapping("/company/delete")
    public Result companyDelete(Long companyId){
        userCompanyService.deleteById(companyId);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改用户信息", tags = {"用户管理"}, notes = "修改用户信息")
    @PutMapping("/update")
    public Result update(@RequestBody UserInfo userInfo){
        userInfoService.update(userInfo);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "Network", tags = {"用户管理"}, notes = "Network")
    @GetMapping("/network")
    public Result network(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String Industry,
                          @RequestParam(required = false) Long countryId,
                          @RequestParam(required = false) Long cityId,
                          Authentication authentication){
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("Industry",Industry);
        params.put("countryId",countryId);
        params.put("cityId",cityId);
        params.put("userId",getAuthUser(authentication).getId());
        PageHelper.startPage(page,size);
        List<UserNetWorkVo> netWorkVos = userInfoService.network(params);
        PageInfo<UserNetWorkVo> netWorkVoPageInfo = new PageInfo<>(netWorkVos);
        return resultGenerator.genSuccessResult(netWorkVoPageInfo);
    }

    @ApiOperation(value = "用户的network", tags = {"用户管理"}, notes = "用户的network")
    @GetMapping(value="/my/network",name="用户的network")
    public Result myNetwork(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer size,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String Industry,
                            @RequestParam(required = false) Long countryId,
                            @RequestParam(required = false) Long cityId,
                            Authentication authentication) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("Industry",Industry);
        params.put("countryId",countryId);
        params.put("cityId",cityId);
        params.put("userId",getAuthUser(authentication).getId());
        params.put("onlySelf",true);

        PageHelper.startPage(page,size);
        List<UserNetWorkVo> netWorkVos = userInfoService.network(params);
        PageInfo<UserNetWorkVo> netWorkVoPageInfo = new PageInfo<>(netWorkVos);
        return resultGenerator.genSuccessResult(netWorkVoPageInfo);
    }



    @ApiOperation(value = "用户管理列表信息", tags = {"用户管理"}, notes = "用户管理列表信息")
    @GetMapping(value="/list",name="用户管理详细信息")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long groupId,
            @RequestParam(required = false) Long gradeId
    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("groupId",groupId);
        params.put("gradeId",gradeId);
        PageHelper.startPage(page,size);
        List<UserInfoVo> userInfoVoList = userInfoService.managerList(page,size,params);
        PageInfo<UserInfoVo> pageInfo = new PageInfo<>(userInfoVoList);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "用户端用户详情", tags = {"用户管理"}, notes = "用户端用户详情")
    @GetMapping(value="/detail",name="用户端用户详情")
    public Result detail(Long userId,Authentication authentication) {

        UserInfoVo userInfoVo = userInfoService.detail(userId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult(userInfoVo);
    }

    @ApiOperation(value = "用户忘记密码", tags = {"用户管理"}, notes = "用户忘记密码")
    @PutMapping(value="forgot/password",name="用户忘记密码")
    public Result forgotPassword(
            String phoneNumber,
            String verificationCode,
            String password
    ) {
        String key = verificationCodeKey(phoneNumber, Const.VERIFICATION_FORGOT);
        String code = redisTemplate.opsForValue().get(key);
        if(code == null){
            return resultGenerator.genFailResult(VERIFICATION_INVALID);
        }
        if(!verificationCode.equals(code)){
            return resultGenerator.genFailResult(VERIFICATION_ERROR);
        }
        User user = userService.findByLoginName(phoneNumber);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.update(user);
        redisTemplate.delete(key);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户职位下拉选项", tags = {"用户管理"}, notes = "用户职位下拉选项")
    @GetMapping(value="/position/list",name="用户职位下拉选项")
    public Result positionList() {
        return resultGenerator.genSuccessResult(positionService.findAll());
    }

    /**
     * 验证码redis key
     * @param phoneNumber
     * @param type 1 注册 2 忘记密码
     * @return
     */
    String verificationCodeKey(String phoneNumber,Integer type){
        return "type"+type+":"+phoneNumber;
    }

}
