package com.online_course.server.mapper;

import com.online_course.server.domain.MemberCourse;
import com.online_course.server.domain.MemberCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCourseMapper {
    long countByExample(MemberCourseExample example);

    int deleteByExample(MemberCourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(MemberCourse record);

    int insertSelective(MemberCourse record);

    List<MemberCourse> selectByExample(MemberCourseExample example);

    MemberCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MemberCourse record, @Param("example") MemberCourseExample example);

    int updateByExample(@Param("record") MemberCourse record, @Param("example") MemberCourseExample example);

    int updateByPrimaryKeySelective(MemberCourse record);

    int updateByPrimaryKey(MemberCourse record);
}