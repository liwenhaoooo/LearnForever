package com.online_course.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.online_course.server.domain.MemberCourse;
import com.online_course.server.domain.MemberCourseExample;
import com.online_course.server.dto.MemberCourseDto;
import com.online_course.server.dto.PageDto;
import com.online_course.server.mapper.MemberCourseMapper;
import com.online_course.server.util.CopyUtil;
import com.online_course.server.util.UuidUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
        import java.util.Date;
@Service
public class MemberCourseService {

    @Resource
    private MemberCourseMapper memberCourseMapper;
    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        MemberCourseExample memberCourseExample = new MemberCourseExample();
        List<MemberCourse> memberCourseList = memberCourseMapper.selectByExample(memberCourseExample);
        PageInfo<MemberCourse> pageInfo = new PageInfo<>(memberCourseList);
        pageDto.setTotal(pageInfo.getTotal());
        List<MemberCourseDto> memberCourseDtoList = CopyUtil.copyList(memberCourseList, MemberCourseDto.class);
        pageDto.setList(memberCourseDtoList);
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(MemberCourseDto memberCourseDto) {
        MemberCourse memberCourse = CopyUtil.copy(memberCourseDto, MemberCourse.class);
        if (StringUtil.isEmpty(memberCourseDto.getId())) {
            this.insert(memberCourse);
        }else {
            this.update(memberCourse);
        }
    }
    /**
     * 新增
     */
    private void insert(MemberCourse memberCourse) {

                Date now = new Date();
        memberCourse.setId(UuidUtil.getShortUuid());
        memberCourseMapper.insert(memberCourse);
    }
    /**
     * 更新
     */
    private void update(MemberCourse memberCourse) {
        memberCourseMapper.updateByPrimaryKey(memberCourse);
    }
    /**
     * 删除
     */
    public void delete(String id) {
        memberCourseMapper.deleteByPrimaryKey(id);
    }
}
