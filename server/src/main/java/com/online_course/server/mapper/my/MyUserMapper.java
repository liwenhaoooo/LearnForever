package com.online_course.server.mapper.my;

import com.online_course.server.dto.ResourceDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wenhaoli
 * @date 2022/07/17 20:46
 */
public interface MyUserMapper {
    List<ResourceDto> findResources(@Param("userId") String userId);
}
