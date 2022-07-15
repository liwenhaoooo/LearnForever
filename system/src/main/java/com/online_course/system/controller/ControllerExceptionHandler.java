package com.online_course.system.controller;

import com.online_course.server.dto.ResponseDto;
import com.online_course.server.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wenhaoli
 * @date 2022/07/15 21:28
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseDto businessExceptionHandler(BusinessException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setSuccess(false);
        LOG.error("业务异常：{}", e.getCode().getDesc());
        responseDto.setMessage(e.getCode().getDesc());
        return responseDto;
    }
}
