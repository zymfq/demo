package com.zym.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zym
 * @Date 2019-06-17-18:50
 */
@RestController  //
public class Hello {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello SpringBoot!";
    }
}
