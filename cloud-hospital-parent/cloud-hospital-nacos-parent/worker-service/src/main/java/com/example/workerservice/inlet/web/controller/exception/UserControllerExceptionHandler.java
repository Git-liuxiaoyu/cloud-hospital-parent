package com.example.workerservice.inlet.web.controller.exception;

import com.example.workerservice.inlet.web.controller.UserController;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.api.ILoginUserCommandHandler;
import com.example.workerservice.service.api.IUpdateUserPwdCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller 异常处理类
 */
@RestControllerAdvice(assignableTypes = UserController.class)
public class UserControllerExceptionHandler {

    /**
     * 异常处理 - 参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseResult<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 用户找不到
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ILoginUserCommandHandler.UserNotFountException.class)
    public ResponseResult<Void> handleUserNotFountException(ILoginUserCommandHandler.UserNotFountException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 验证码不正确
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdateUserPwdCommandHandler.IncorrectVerifyCodeException.class)
    public ResponseResult<Void> handleIncorrectVerifyCodeException(IUpdateUserPwdCommandHandler.IncorrectVerifyCodeException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 验证码不存在
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdateUserPwdCommandHandler.InvalidVerifyCodeException.class)
    public ResponseResult<Void> handleInvalidVerifyCodeException(IUpdateUserPwdCommandHandler.InvalidVerifyCodeException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

}
