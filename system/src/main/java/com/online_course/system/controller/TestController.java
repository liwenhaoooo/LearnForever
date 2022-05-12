package com.online_course.system.controller;

import com.online_course.system.domain.Test;
import com.online_course.system.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wenhaoli
 * @date 2022/05/12 16:46
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;
    @RequestMapping("/test")
    public List<Test> test(){
        return testService.list();
    }
}
