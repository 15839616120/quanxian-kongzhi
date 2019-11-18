package com.fangtianxia.controller;

import com.fangtianxia.common.AuthorityAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot 项目搭建启动测试类
 * @author wyz
 */
@RequestMapping("system")
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hell";
    }

    /**
     *  name:name的值用于拦截器的判断，是用户角色的值
     */
    @AuthorityAnnotation(name = "hello1")
    @RequestMapping("hello1")
    public String hello1(){
        return "hell";
    }
}
