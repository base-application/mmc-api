package com.wanghuiwen.user.controller;

import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.GuideLine;
import com.wanghuiwen.user.service.GuideLineService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
* Created by wanghuiwen on 2021/10/22.
*/
@Api(value = "Guideline", tags = {"Guideline"})
@RestController
@RequestMapping("/guide/line")
public class GuideLineController extends Ctrl{
    @Resource
    private GuideLineService guideLineService;

    @ApiOperation(value = "Guideline添加", tags = {"Guideline"}, notes = "Guideline添加")
    @PostMapping(value="/add",name="Guideline添加")
    public Result add(@RequestBody GuideLine guideLine) {
        guideLineService.save(guideLine);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "Guideline删除", tags = {"Guideline"}, notes = "Guideline删除")
    @DeleteMapping(value="/delete",name="Guideline删除")
    public Result add(Long guideLineId) {
        guideLineService.deleteById(guideLineId);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "Guideline列表信息", tags = {"Guideline"}, notes = "Guideline列表信息")
    @GetMapping(value = "/list", name = "Guideline列表信息")
    public Result list() {
        return resultGenerator.genSuccessResult(guideLineService.findAll());
    }
}
