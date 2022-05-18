package com.online_course.server.exception;

/**
 * @author wenhaoli
 * @date 2022/05/18 15:26
 */
public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }
}
