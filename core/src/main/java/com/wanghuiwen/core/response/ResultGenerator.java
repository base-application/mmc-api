package com.wanghuiwen.core.response;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 响应结果生成工具
 */
@Component
public class ResultGenerator {
    @Resource
    private MessageSource messageSource;
    public Result genSuccessResult() {
        return new Result(ResultEnum.SUCCESS_MESSAGE,null).setMessage(messageSource.getMessage("200", null, LocaleContextHolder.getLocale()));
    }

    public Result genSuccessResult(Object data) {
        return new Result(ResultEnum.SUCCESS_MESSAGE,data).setMessage(messageSource.getMessage("200", null, LocaleContextHolder.getLocale()));
    }

    public Result genSuccessResult(ResultEnum resultEnum,Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(messageSource.getMessage(String.valueOf(resultEnum.getCode()), null, LocaleContextHolder.getLocale()))
                .setData(data);
    }

    public Result genFailResult(ResultEnum resultEnum) {
        return new Result(resultEnum).setMessage(messageSource.getMessage(String.valueOf(resultEnum.getCode()), null, LocaleContextHolder.getLocale()));
    }

    public Result genResult(ResultEnum resultEnum) {
        return new Result(resultEnum).setMessage(messageSource.getMessage(String.valueOf(resultEnum.getCode()), null, LocaleContextHolder.getLocale()));
    }

    public Result genExceptionResult(Exception e) {
        return new Result(e);
    }

    public Result genExceptionResult(Exception e,String code) {
        return new Result(e).setMessage(messageSource.getMessage(code, null, LocaleContextHolder.getLocale()));
    }
}
