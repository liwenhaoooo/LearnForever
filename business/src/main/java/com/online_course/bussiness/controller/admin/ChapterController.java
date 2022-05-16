package com.online_course.bussiness.controller.admin;

import com.online_course.server.domain.Chapter;
import com.online_course.server.dto.ChapterDto;
import com.online_course.server.dto.PageDto;
import com.online_course.server.service.ChapterService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wenhaoli
 * @date 2022/05/12 16:46
 */
@RequestMapping("/admin/chapter")
@RestController
public class ChapterController {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    @Resource
    private ChapterService chapterService;
    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto){
        LOG.info("pageDto: {}",pageDto);
        chapterService.list(pageDto);
        return pageDto;
    }
}
