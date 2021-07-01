package com.example.registerservice.inlet.web.controller.exception;

import com.example.registerservice.inlet.web.controller.PatientController;
import com.example.registerservice.service.api.IAddPatientCommandHandler;
import com.example.registerservice.service.api.IQueryPatientByIdCommandHandler;
import com.example.registerservice.service.api.IQueryPatientByIdentityIdCommandHandler;
import com.example.registerservice.service.api.IUpdatePatientCommandHandler;
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

    /**
     * 根据患者身份证查询存在该患者就不能添加
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddPatientCommandHandler.PatientByIdentityIdException.class)
    public ResponseResult<Void> PatientByIdentityIdException(IAddPatientCommandHandler.PatientByIdentityIdException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }


    /**
     * 添加患者失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddPatientCommandHandler.PatientAddException.class)
    public ResponseResult<Void> PatientAddException(IAddPatientCommandHandler.PatientAddException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 根据身份证查询患者异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryPatientByIdentityIdCommandHandler.PatientByIdentityIdNotFoundException.class)
    public ResponseResult<Void> PatientByIdentityIdNotFoundException(IQueryPatientByIdentityIdCommandHandler.PatientByIdentityIdNotFoundException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }

    /**
     * 修改患者信息异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdatePatientCommandHandler.UpdatePatientException.class)
    public ResponseResult<Void> PatientByIdentityIdNotFoundException(IUpdatePatientCommandHandler.UpdatePatientException e) {
        return new ResponseResult<Void>(444, e.getMessage());
    }
}
