package com.example.registerservice.inlet.web.controller.exception;

import com.example.registerservice.inlet.web.controller.RegisterController;
import com.example.registerservice.service.api.*;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    /**
     * 发送验证码到队列和保存redis的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddPhoneGoRedisCommandHandler.AddPhoneGoRedisException.class)
    public ResponseResult<Void> PatientByIdNotFoundException(IAddPhoneGoRedisCommandHandler.AddPhoneGoRedisException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 查询验证码异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryPhoneAndCodeCommandHandler.QueryPhoneAndCodeException.class)
    public ResponseResult<Void> QueryPhoneAndCodeException(IQueryPhoneAndCodeCommandHandler.QueryPhoneAndCodeException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 根据挂号no查询挂号信息异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryRegisterGetByNoCommandHandler.QueryRegisterGetByNoException.class)
    public ResponseResult<Void> QueryPhoneAndCodeException(IQueryRegisterGetByNoCommandHandler.QueryRegisterGetByNoException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 根据id修改挂号的状态异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdateRegisterCommandHandler.UpdateRegisterException.class)
    public ResponseResult<Void> UpdateRegisterException(IUpdateRegisterCommandHandler.UpdateRegisterException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 新增挂号订单异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddRegisterCommandHandler.AddRegisterException.class)
    public ResponseResult<Void> UpdateRegisterException(IAddRegisterCommandHandler.AddRegisterException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 该手机号没有挂号订单异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryRegisterByPhoneCommandHandler.QueryRegisterByPhoneException.class)
    public ResponseResult<Void> QueryRegisterByPhoneException(IQueryRegisterByPhoneCommandHandler.QueryRegisterByPhoneException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 根据挂号id没有查询到挂号订单异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryRegisterByIdCommandHandler.QueryRegisterByIdException.class)
    public ResponseResult<Void> QueryRegisterByIdException(IQueryRegisterByIdCommandHandler.QueryRegisterByIdException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }
}
