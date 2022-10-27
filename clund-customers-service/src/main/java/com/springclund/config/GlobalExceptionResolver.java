package com.springclund.config;

import com.springclund.pojo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionResolver {
    private static Logger logger= LoggerFactory.getLogger(GlobalExceptionResolver.class);
    // 处理Exception及其子类异常(几乎就是所有异常了)
    @ExceptionHandler(Exception.class)
    // 用在方法上  作用:用来处理指定异常  value属性: 用来处理指定异常类型
    // 写Exception.class就是把Exception及其所有子类异常都处理了
    @ResponseBody   // 将方法的返回值以json的格式返回
    public ResponseEntity<String> exceptionHandler(Exception e){   // 方法名随便，不过为了望文生意，一般就取为exceptionHandler
        System.out.println("进入自定义异常处理"+e.getMessage());
        e.printStackTrace();
        logger.error("服務異常",e);
        return new ResponseEntity(new CommonResult<>(201,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        //                                          服务器内部错误
    }
}

