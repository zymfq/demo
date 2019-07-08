package com.zym.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zym
 * @Date 2019-07-02-21:40
 */
@ControllerAdvice           //标识  让springboot知道他是一个异常处理类   需要和前端页面进行异常交互
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody           //返回错误信息

    private Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }
}
