package com.online_course.bussiness.controller;

import com.online_course.server.domain.Chapter;
import com.online_course.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wenhaoli
 * @date 2022/05/12 16:46
 */
@RestController
public class ChapterController {
    @Resource
    private ChapterService chapterService;
    @RequestMapping("/chapter")
    public List<Chapter> chapter(){
        return chapterService.list();
    }
}
