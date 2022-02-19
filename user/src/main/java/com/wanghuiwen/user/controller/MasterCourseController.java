package com.wanghuiwen.user.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.CourseCategory;
import com.wanghuiwen.user.model.MasterCourse;
import com.wanghuiwen.user.service.CourseCategoryService;
import com.wanghuiwen.user.service.MasterCourseService;
import com.wanghuiwen.user.vo.CourseAddVo;
import com.wanghuiwen.user.vo.ReferralVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import io.swagger.annotations.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* Created by wanghuiwen on 2022/02/19.
*/
@Api(value = "课程", tags = {"课程"})
@RestController
@RequestMapping("/master/course")
public class MasterCourseController extends Ctrl{
    @Resource
    private MasterCourseService masterCourseService;
    @Resource
    private CourseCategoryService courseCategoryService;


    @ApiOperation(value = "课程添加", tags = {"课程"}, notes = "课程添加")
    @PostMapping(value="/add",name="课程添加")
    public Result add(@ApiParam CourseAddVo masterCourse) {
        masterCourseService.add(masterCourse);
        return  resultGenerator.genSuccessResult();
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

    @ApiOperation(value = "课程详细信息", tags = {"课程"}, notes = "课程详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "课程id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/detail",name="课程详细信息")
    public Result detail(@RequestParam Integer id) {
        CourseAddVo masterCourse = masterCourseService.detail(id);
        return resultGenerator.genSuccessResult(masterCourse);
    }

    @ApiOperation(value = "课程列表信息", tags = {"课程"}, notes = "课程列表信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码", dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "size", value = "每页显示的条数", dataType = "String", paramType = "query", defaultValue = "10")
    })
    @PostMapping(value = "/list", name = "课程列表信息")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) Long courseId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String courseName
    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("courseId",courseId);
        params.put("categoryId",categoryId);
        params.put("courseName",courseName);
        PageHelper.startPage(page,size);
        List<MasterCourse> courses = masterCourseService.list(params);

        PageInfo<MasterCourse> pageInfo = new PageInfo<>(courses);
        return resultGenerator.genSuccessResult(pageInfo);
    }



    @ApiOperation(value = "课程分类添加", tags = {"课程分类"}, notes = "课程分类添加")
    @PostMapping(value="/category/add",name="课程分类添加")
    public Result add(@ApiParam CourseCategory courseCategory) {
        if(courseCategory.getCategoryId()!=null){
            courseCategoryService.update(courseCategory);
        }else {
            courseCategory.setCreateTime(new Date().getTime());
            courseCategoryService.save(courseCategory);
        }
        return resultGenerator.genSuccessResult(courseCategory.getCategoryId());
    }


    @ApiOperation(value = "课程分类删除", tags = {"课程分类"}, notes = "课程分类删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",required=true, value = "课程分类id", dataType = "Long", paramType = "query")
    })
    @PostMapping(value="/category/delete",name="课程分类删除")
    public Result categoryDelete(@RequestParam Long id) {
        courseCategoryService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "课程分类列表信息", tags = {"课程分类"}, notes = "课程分类列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数", dataType = "String", paramType = "query", defaultValue = "10")
    })
    @PostMapping(value = "/category/list", name = "课程分类列表信息")
    public Result categoryList(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        PageHelper.startPage(page,size);
        List<CourseCategory> vos = courseCategoryService.list();
        PageInfo<CourseCategory> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
