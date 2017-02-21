package com.shenchao.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by shenchao on 2017/2/5.
 */
@ControllerAdvice
public class GlobalHandleExecption {

    @ExceptionHandler(Exception.class)
    public String handleExecption(Exception e) {
        System.out.println(e);
        return "500";
    }

}
