package com.wanghuiwen.web;

import com.wanghuiwen.model.AppHistory;
import com.wanghuiwen.service.AppHistoryService;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
* Created by CodeGenerator on 2019/11/14.
*/
@Api(value = "app发布历史", tags = {"app发布历史"})
@RestController
@RequestMapping("/app/history")
public class AppHistoryController extends Ctrl {
    @Resource
    private AppHistoryService appHistoryService;

    @ApiOperation(value = "app发布历史添加", tags = {"app发布历史"}, notes = "app发布历史添加")
    @PostMapping(value="/add",name="app发布历史添加")
    public Result add(@ApiParam AppHistory appHistory) {
        appHistory.setCreateDate(new Date());
        appHistoryService.save(appHistory);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "app发布历史删除", tags = {"app发布历史"}, notes = "app发布历史删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "app发布历史id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/delete",name="app发布历史删除")
    public Result delete(@RequestParam Long id) {
        appHistoryService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "app发布历史修改", tags = {"app发布历史"}, notes = "app发布历史修改,对象主键必填")
    @PostMapping(value="/update",name="app发布历史修改")
    public Result update(@ApiParam AppHistory appHistory) {
        appHistoryService.update(appHistory);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "app发布历史详细信息", tags = {"app发布历史"}, notes = "app发布历史详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "app发布历史id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/detail",name="app发布历史详细信息")
    public Result detail(@RequestParam Integer id) {
        AppHistory appHistory = appHistoryService.findById(id);
        return resultGenerator.genSuccessResult(appHistory);
    }

    @ApiOperation(value = "app发布历史列表信息", tags = {"app发布历史"}, notes = "app发布历史列表信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "appid", value = "appid", dataType = "long", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "页码", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "size", value = "每页显示的条数", dataType = "String", paramType = "query",defaultValue="10")
    })
    @PostMapping(value="/list",name="app发布历史列表信息")
    public Result list(@RequestParam Long appid) {

        Condition c= new Condition(AppHistory.class);
        c.createCriteria().andEqualTo("appId",appid);

        List<AppHistory> list = appHistoryService.findByCondition(c);
        return resultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value = "app发布历史列表信息", tags = {"app发布历史"}, notes = "app发布历史列表信息")
    @PostMapping(value="/last",name="app发布历史列表信息")
    public Result lastVersion(@RequestParam Long appId,@RequestParam String platform) {
        AppHistory last = appHistoryService.findLast(appId,platform);
        return resultGenerator.genSuccessResult(last);
    }
}
