package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.config.FmcUtil;
import com.wanghuiwen.user.service.NewestStoryService;
import com.wanghuiwen.user.vo.NewestStoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* Created by wanghuiwen on 2021/10/20.
*/
@Api(value = "新闻", tags = {"新闻"})
@RestController
@RequestMapping("/newest/story")
public class NewestStoryController extends Ctrl{
    @Resource
    private NewestStoryService newestStoryService;

    @ApiOperation(value = "新闻添加", tags = {"新闻"}, notes = "新闻添加")
    @PostMapping(value="/add",name="新闻添加")
    public Result add(@RequestBody NewestStoryVo newestStoryVo) {
        newestStoryService.add(newestStoryVo);
        FmcUtil.sendAll(newestStoryVo.getTitle(), newestStoryVo.getDescription(),null);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "新闻删除", tags = {"新闻"}, notes = "新闻删除")
    @DeleteMapping(value="/delete",name="新闻删除")
    public Result delete(@RequestParam Long id) {
        newestStoryService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "新闻列表信息", tags = {"新闻"}, notes = "新闻列表信息")
    @GetMapping(value = "/list", name = "新闻列表信息")

    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long startDate,
            @RequestParam(required = false) Long endDate
    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("title",title);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        PageHelper.startPage(page,size);
        List<NewestStoryVo> vos = newestStoryService.list(params);
        PageInfo<NewestStoryVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
