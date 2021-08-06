package com.wanghuiwen.base.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.base.config.ProjectConstant;
import com.wanghuiwen.base.model.*;
import com.wanghuiwen.base.service.*;
import com.wanghuiwen.base.vo.DepartmentTree;
import com.wanghuiwen.base.vo.ElTree;
import com.wanghuiwen.base.vo.RoleApiAdd;
import com.wanghuiwen.base.vo.UserRoleAdd;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultEnum;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@io.swagger.annotations.Api(value = "用户模块", tags = {"用户模块"})
@RestController
public class ApiController extends Ctrl {
    @Resource
    private MenuService menuService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private ApiService apiService;
    @Resource
    private SysWhitelistService sysWhitelistService;
    @Resource
    private SysDepartmentService sysDepartmentService;
    @Resource
    private SysLogService sysLogService;

    @GetMapping(value = "user/generate/routes",name = "前端获取菜单")
    public Result code(Authentication authentication) {
        List<Menu> menus = userService.getByMenus(getAuthUser(authentication).getId());
        Map<Long, List<Menu>> res = menus.stream().collect(Collectors.groupingBy(Menu::getPid));
        List<Menu> parent = res.get(0L);
        for (Menu menu : parent) {
            menu.setChildren(res.get(menu.getId()));
        }
        return resultGenerator.genSuccessResult(parent);
    }

    @PostMapping(value = "refresh/token",name = "刷新token")
    public Result refresh(Authentication authentication) {
        return userService.login(getAuthUser(authentication));
    }

    @GetMapping(value = "user/list",name = "用户列表")
    public Result userList(
            @RequestParam(defaultValue = "0")Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String nickName,
            Long id,
            String loginName,
            Long roleId) {
        Map<String,Object> params = new HashMap<>();
        params.put("nickName",nickName);
        params.put("id",id);
        params.put("loginName",loginName);
        params.put("roleId",roleId);

        PageHelper.startPage(page,size);
        List<User> users = userService.list(params);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return resultGenerator.genSuccessResult(pageInfo);
    }


    @GetMapping(value = "role/list",name = "角色列表")
    public Result roleList() {
        List<Role> roles = roleService.findAll();
        return resultGenerator.genSuccessResult(roles);
    }

    @GetMapping(value = "user/role",name = "用户角色")
    public Result userRole(Long userId) {
        List<Role> roles = roleService.getByUser(userId);
        return resultGenerator.genSuccessResult(roles);
    }

    @PostMapping(value = "user/add",name = "添加/修改用户")
    public Result userAdd(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return resultGenerator.genSuccessResult(user.getId());
    }


    @PutMapping(value = "user/role",name = "修改用户角色")
    public Result userRoleUpdate(@RequestBody UserRoleAdd add) {
        return userService.addRole(add.getRoles(),add.getUserId());
    }

    @GetMapping(value = "api/list",name = "接口列表")
    public Result apiList() {
        List<Api> roles = apiService.findAll();
        Map<String, List<Api>> res = roles.stream().collect(Collectors.groupingBy(Api::getModule));

        List<ElTree<Api>> elTrees = new ArrayList<>();
        for (Map.Entry<String, List<Api>> m : res.entrySet()) {
            ElTree<Api> elTree = new ElTree<>();
            elTree.setId(m.getKey());
            elTree.setName(m.getKey());
            elTree.setChildren(m.getValue());
            elTrees.add(elTree);
        }
        return resultGenerator.genSuccessResult(elTrees);
    }

    @GetMapping(value = "role/api",name = "角色接口列表")
    public Result roleApi(Long roleId) {
        List<Api> apis = apiService.getByRole(roleId);
        return resultGenerator.genSuccessResult(apis);
    }

    @PutMapping(value = "role/api",name = "角色添加接口")
    public Result roleApiAdd(@RequestBody @Validated RoleApiAdd add) {
        return roleService.addApi(add);
    }

    @PutMapping(value = "role/add",name = "角色添加")
    public Result roleAdd(@RequestBody  Role add) {
        roleService.saveOrUpdate(add);
        return resultGenerator.genSuccessResult(add.getId());
    }

    @DeleteMapping(value = "role/delete",name = "角色删除")
    public Result delete(Long id) {

        Map<String,Object> params = new HashMap<>();
        params.put("roleId",id);
        List<User> users = userService.list(params);
        if (!CollectionUtils.isEmpty(users)) {
            return resultGenerator.genResult(ResultEnum.ROLE_HAS_USER);
        }
        roleService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }


    @GetMapping(value = "menu/list",name = "菜单列表")
    public Result menu() {
        List<Menu> menus = menuService.findAll();
        Map<Long, List<Menu>> res = menus.stream().collect(Collectors.groupingBy(Menu::getPid));
        List<Menu> parent = res.get(0L);
        addMenuChild(parent,res);

        return resultGenerator.genSuccessResult(parent);
    }

    private void addMenuChild(List<Menu> menus, Map<Long, List<Menu>> res){
        for (Menu menu : menus) {
            menu.setChildren(res.get(menu.getId()));
            if(!CollectionUtils.isEmpty(res.get(menu.getId()))){
                addMenuChild(res.get(menu.getId()),res);
            }
        }
    }

    @PostMapping(value = "menu/add",name = "菜单列表")
    public Result menu(@RequestBody Menu menu) {
        menuService.saveOrUpdate(menu);
        return resultGenerator.genSuccessResult(menu.getId());
    }

    @GetMapping(value = "role/menu",name = "菜单列表")
    public Result roleMenu(Long roleId) {
        List<Menu> menus = menuService.getByRole(roleId);
        return resultGenerator.genSuccessResult(menus);
    }

    @PutMapping(value = "role/menu",name = "角色添加菜单")
    public Result roleMenu(@RequestBody @Validated RoleApiAdd add) {
        return roleService.addMenu(add);
    }

    @DeleteMapping(value = "menu/delete",name = "菜单列表")
    public Result menu(Long id) {
        menuService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @GetMapping(value = "white/list",name = "白名单列表")
    public Result whitelist() {
        return resultGenerator.genSuccessResult(sysWhitelistService.findAll());
    }


    @PutMapping(value = "white/list/add",name = "添加白名单")
    @CacheEvict(value=ProjectConstant.WHITE_LIST_CACHE_KEY,keyGenerator = "baseKeyGenerator")
    public Result whitelistAdd(@RequestBody SysWhitelist whitelist) {
        sysWhitelistService.saveOrUpdate(whitelist);
        return resultGenerator.genSuccessResult(whitelist.getId());
    }

    @GetMapping(value = "department/list",name = "组织机构列表")
    public Result departmentList() {
        List<DepartmentTree> roleTree = new ArrayList<>();

        List<SysDepartment> departments = sysDepartmentService.findAll();
        List<Role> roles = roleService.findAll();
        for (Role role : roles) {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(role.getId());
            departmentTree.setName(role.getName());
            departmentTree.setPid(role.getDeptId());
            departmentTree.setType(2);
            departmentTree.setEkey("2"+role.getId());
            roleTree.add(departmentTree);
        }

        for (SysDepartment department : departments) {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(department.getId());
            departmentTree.setName(department.getName());
            departmentTree.setPid(department.getPid());
            departmentTree.setType(1);
            departmentTree.setEkey("1"+department.getId());
            roleTree.add(departmentTree);
        }

        Map<Long, List<DepartmentTree>> roleGroup = roleTree.stream().collect(Collectors.groupingBy(DepartmentTree::getPid));

        List<DepartmentTree> parent = roleGroup.get(0L);
        addChildDepartment(parent,roleGroup);

         return resultGenerator.genSuccessResult(parent);
    }

   private void addChildDepartment(List<DepartmentTree> parent , Map<Long, List<DepartmentTree>>  group ){

       for (DepartmentTree departmentTree : parent) {
           if(!CollectionUtils.isEmpty(group.get(departmentTree.getId())) && departmentTree.getType() ==1 ){
               departmentTree.setChildren(group.get(departmentTree.getId()));
               addChildDepartment(group.get(departmentTree.getId()),group);
           }

       }
    }


    @PutMapping(value = "department/add",name = "添加部门")
    public Result departmentAdd(@RequestBody SysDepartment department) {
        sysDepartmentService.saveOrUpdate(department);
        return resultGenerator.genSuccessResult(department.getId());
    }

    @DeleteMapping(value = "department/delete",name = "删除部门")
    public Result departmentAdd(Long id) {
        sysDepartmentService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @GetMapping(value = "log/list",name = "日志列表")
    public Result logList(
            @RequestParam(defaultValue = "0")Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Long startDate,
            Long endDate,
            String method,
            String loginName

    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("method",method);
        params.put("loginName",loginName);
        PageHelper.startPage(page,size);
        List<ResultMap<String,Object>> sysLogs = sysLogService.list(params);
        PageInfo<ResultMap<String,Object>> pageInfo = new PageInfo<>(sysLogs);
        return resultGenerator.genSuccessResult(pageInfo);
    }


}
