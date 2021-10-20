package com.wanghuiwen.user.controller;

import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



/**
* Created by wanghuiwen on 2021/10/20.
*/
@Api(value = "用户级别", tags = {"用户级别"})
@RestController
@RequestMapping("/grade")
public class GradeController extends Ctrl{
    @Resource
    private GradeService gradeService;

    @ApiOperation(value = "用户级别列表信息", tags = {"用户级别"}, notes = "用户级别列表信息")
    @GetMapping(value = "/list", name = "用户级别列表信息")
    public Result list() {
        return resultGenerator.genSuccessResult(gradeService.findAll());
    }
}
