package com.wanghuiwen.user.controller;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.MasterCourse;
import com.wanghuiwen.user.service.MasterCourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import io.swagger.annotations.*;



/**
* Created by wanghuiwen on 2022/02/19.
*/
@Api(value = "课程", tags = {"课程"})
@RestController
@RequestMapping("/master/course")
public class MasterCourseController extends Ctrl{
    @Resource
    private MasterCourseService masterCourseService;

    @ApiOperation(value = "课程添加", tags = {"课程"}, notes = "课程添加")
    @PostMapping(value="/add",name="课程添加")
    public Result add(@ApiParam MasterCourse masterCourse) {
        masterCourseService.save(masterCourse);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "课程删除", tags = {"课程"}, notes = "课程删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "课程id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/delete",name="课程删除")
    public Result delete(@RequestParam Long id) {
        masterCourseService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "课程修改", tags = {"课程"}, notes = "课程修改,对象主键必填")
    @PostMapping(value="/update",name="课程修改")
    public Result update(@ApiParam MasterCourse masterCourse) {
        masterCourseService.update(masterCourse);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "课程详细信息", tags = {"课程"}, notes = "课程详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "课程id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/detail",name="课程详细信息")
    public Result detail(@RequestParam Integer id) {
        MasterCourse masterCourse = masterCourseService.findById(id);
        return resultGenerator.genSuccessResult(masterCourse);
    }

    @ApiOperation(value = "课程列表信息", tags = {"课程"}, notes = "课程列表信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "search", value = "查询条件json", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "order", value = "排序json", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "页码", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "size", value = "每页显示的条数", dataType = "String", paramType = "query", defaultValue = "10")
    })
    @PostMapping(value = "/list", name = "课程列表信息")
    public Result list() {
        return resultGenerator.genSuccessResult(masterCourseService.findAll());
    }
}
