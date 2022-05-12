package com.online_course.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenhaoli
 * @date 2022/05/12 16:46
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
