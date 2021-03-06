package com.wanghuiwen.web;

import com.wanghuiwen.model.App;
import com.wanghuiwen.model.AppHistory;
import com.wanghuiwen.service.AppHistoryService;
import com.wanghuiwen.service.AppService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* Created by CodeGenerator on 2019/11/14.
*/
@Api(value = "app发布", tags = {"app发布"})
@RestController
@RequestMapping("/app")
public class AppController extends Ctrl {
    @Resource
    private AppService appService;

    @Resource
    private AppHistoryService appHistoryService;

    @ApiOperation(value = "app发布添加", tags = {"app发布"}, notes = "app发布添加")
    @PostMapping(value="/add",name="app发布添加")
    public Result add(@ApiParam App app,
                      HttpServletRequest request) {
        return appService.add(app,request);
    }

    @ApiOperation(value = "app发布删除", tags = {"app发布"}, notes = "app发布删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "app发布id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/delete",name="app发布删除")
    public Result delete(@RequestParam Long id) {
        appService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "app发布修改", tags = {"app发布"}, notes = "app发布修改,对象主键必填")
    @PostMapping(value="/update",name="app发布修改")
    public Result update(@ApiParam App app) {
        appService.update(app);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "app发布详细信息", tags = {"app发布"}, notes = "app发布详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "app发布id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/detail",name="app发布详细信息")
    public Result detail(@RequestParam Integer id) {
        App app = appService.findById(id);
        return resultGenerator.genSuccessResult(app);
    }

    @ApiOperation(value = "app发布列表信息", tags = {"app发布"}, notes = "app发布列表信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "where", value = "条件构建", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "页码", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "size", value = "每页显示的条数", dataType = "String", paramType = "query",defaultValue="10")
    })
    @PostMapping(value="/list",name="app发布列表信息")
    public Result list(@RequestParam(defaultValue = "[]") String  where ,
                       @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {


        PageHelper.startPage(page, size);
        List<App> list = appService.findAll();
        PageInfo<App> pageInfo = new PageInfo<>(list);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "app下载页", tags = {"app发布"}, notes = "app下载页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",required=true, value = "app发布id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/index",name="app发布详细信息")
    public Result index(@RequestParam Long id) {
        Map<String ,Object> params = new HashMap<>();
        params.put("appId",id);
        App app = appService.findById(id);

        List<AppHistory> histories=appHistoryService.findeByAppId(params);
        Map<String,Object> res = new HashMap<>();
        res.put("app",app);
        res.put("history",histories);

        return resultGenerator.genSuccessResult(res);
    }

}
