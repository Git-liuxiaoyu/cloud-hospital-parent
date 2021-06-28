package com.example.registerservice.inlet.web.controller.exception;

import com.example.registerservice.inlet.web.controller.RegisterController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:29
 * @Description: 挂号controller的异常捕获
 */
@RestControllerAdvice(assignableTypes = RegisterController.class)
public class RegisterControllerExceptionHandler {
}
