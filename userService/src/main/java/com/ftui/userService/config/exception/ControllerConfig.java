package com.ftui.userService.config.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.ftui.userService.controller")
public class ControllerConfig{
    @ExceptionHandler(Exception.class)
    public String exceptionHand(Exception ex){
        return ex.getMessage()+"异常了";
    }
    //处理自定义的异常
    @ExceptionHandler(SystemException.class)
    public String customHandler(SystemException e) {
       e.getMessage();
        return "22";
    }
    }

