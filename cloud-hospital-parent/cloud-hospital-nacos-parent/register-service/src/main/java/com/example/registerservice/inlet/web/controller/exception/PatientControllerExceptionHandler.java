package com.example.registerservice.inlet.web.controller.exception;

import com.example.registerservice.inlet.web.controller.PatientController;
import com.example.registerservice.service.api.IQueryPatientByIdCommandHandler;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:29
 * @Description: 病人的Controller异常捕获
 */
@RestControllerAdvice(assignableTypes = PatientController.class)
public class PatientControllerExceptionHandler {

    /**
     * 根据id查询数据库没有查询到数据抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryPatientByIdCommandHandler.PatientByIdNotFoundException.class)
    public ResponseResult<Void> PatientByIdNotFoundException(IQueryPatientByIdCommandHandler.PatientByIdNotFoundException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }
}
