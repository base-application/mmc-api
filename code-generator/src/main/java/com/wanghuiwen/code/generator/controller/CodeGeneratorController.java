package com.wanghuiwen.code.generator.controller;


import com.wanghuiwen.code.generator.service.GeneratorService;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.response.ResultGenerator;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
@Api(value = "生成代码", tags = {"生成代码"})
@Controller
@RequestMapping("/generator")
public class CodeGeneratorController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private GeneratorService generatorService;
    @Resource
    private ResultGenerator resultGenerator;


    public Result generatorCodeModel(@RequestParam String moduleName,
                                     @RequestParam String tableName,
                                     @RequestParam String businessName) {
        return generatorService.genCode(true, false, false, false, businessName, tableName, moduleName);
    }


    public Result generatorCodeModelAndMapper(@RequestParam String moduleName,
                                              @RequestParam String tableName,
                                              @RequestParam String businessName) {
        generatorService.genCode(true, true, false, false, businessName, tableName, moduleName);
        return resultGenerator.genSuccessResult();
    }


    public Result generatorCodeService(@RequestParam String moduleName,
                                       @RequestParam String tableName,
                                       @RequestParam String businessName) {
        return generatorService.genCode(false, false, true, false, businessName, tableName, moduleName);
    }


    public Result generatorCodeController(@RequestParam String moduleName,
                                          @RequestParam String tableName,
                                          @RequestParam String businessName) {


        return generatorService.genCode(false, false, false, true, businessName, tableName, moduleName);
    }

    @GetMapping(value = "/code")
    public String code(Model model) {
        return "/generator.html";
    }

    @PostMapping(value = "/code/submit",name = "生成代码")
    @ResponseBody
    public Result code(@RequestParam String moduleName,
                       @RequestParam String tableName,
                       @RequestParam String businessName,
                       @RequestParam(required = false) String modelOnly,
                       @RequestParam(required = false) String modelAndMapper,
                       @RequestParam(required = false) String service,
                       @RequestParam(required = false) String controller) {
        Result result = new Result();
        if (modelOnly != null && modelAndMapper == null){
            result =  generatorCodeModel(moduleName, tableName, businessName);
            if (result.getCode()!= 200) return result;
        }
        if (modelAndMapper != null) {
            result = generatorCodeModelAndMapper(moduleName, tableName, businessName);
            if (result.getCode()!= 200) return result;
        }
        if (service != null) {
            result = generatorCodeService(moduleName, tableName, businessName);
            if (result.getCode()!= 200) return result;
        }
        if (controller != null){
            result = generatorCodeController(moduleName, tableName, businessName);
            if (result.getCode()!= 200) return result;
        }
        return resultGenerator.genSuccessResult();
    }

}
