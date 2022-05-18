package com.online_course.bussiness.controller.admin;

import com.online_course.server.domain.Chapter;
import com.online_course.server.dto.ChapterDto;
import com.online_course.server.dto.PageDto;
import com.online_course.server.dto.ResponseDto;
import com.online_course.server.exception.ValidatorException;
import com.online_course.server.service.ChapterService;
import com.online_course.server.util.ValidatorUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    public static final String BUSINESS_NAME = "大章";

    @Resource
    private ChapterService chapterService;
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        LOG.info("pageDto: {}",pageDto);
        ResponseDto responseDto = new ResponseDto();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto){
        LOG.info("chapterDto: {}",chapterDto);

            // 保存校验
            ValidatorUtil.require(chapterDto.getName(), "名称");
            ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
            ValidatorUtil.length(chapterDto.getCourseId(), "课程ID", 1, 8);

        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto save(@PathVariable String id){
        LOG.info("id: {}",id);
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }
}
