package com.example.registerservice.inlet.web.controller.exception;

import com.example.registerservice.inlet.web.controller.PatientController;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/07/01/12:57
 * @Description:
 */
@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler({SQLException.class})
    public ResponseResult<Void> HandlerException() {
        return new ResponseResult<Void>(444, "无法执行sql");
    }
}
