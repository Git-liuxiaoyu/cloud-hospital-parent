package com.example.workerservice.inlet.web.controller.exception;

import com.example.workerservice.inlet.web.controller.DoctorRotaController;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.api.doctorrota.IAddDoctorRotaCommandHandler;
import com.example.workerservice.service.api.doctorrota.ICancelDoctorRotaCommandHandler;
import com.example.workerservice.service.api.doctorrota.IRegBackQueryDoctorRotaCommandHandler;
import com.example.workerservice.service.api.doctorrota.IUpdateDoctorRotaCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类 - 捕获 - DoctorRotaController 的异常
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@RestControllerAdvice(assignableTypes = DoctorRotaController.class)
public class DoctorRotaControllerExceptionHandler {

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
     * 异常处理 - 医生不能重复诊室同一时间段
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddDoctorRotaCommandHandler.DoctorIsRotedInOtherRoomException.class)
    public ResponseResult<Void> handleDoctorIsRotedInOtherRoomException(IAddDoctorRotaCommandHandler.DoctorIsRotedInOtherRoomException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 医生不能重复诊室同一时间段
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdateDoctorRotaCommandHandler.DoctorIsRotedInOtherRoomException.class)
    public ResponseResult<Void> handleDoctorIsRotedInOtherRoomException(IUpdateDoctorRotaCommandHandler.DoctorIsRotedInOtherRoomException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 没有找到该医生排班
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ICancelDoctorRotaCommandHandler.DoctorRotaNotFoundException.class)
    public ResponseResult<Void> handleDoctorRotaNotFoundException(ICancelDoctorRotaCommandHandler.DoctorRotaNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 类型转换错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseResult<Void> handleNumberFormatException(NumberFormatException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 日期转换错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IRegBackQueryDoctorRotaCommandHandler.NewDateParseException.class)
    public ResponseResult<Void> handleNumberFormatException(IRegBackQueryDoctorRotaCommandHandler.NewDateParseException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 用户未找到
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddDoctorRotaCommandHandler.WorkerInfoNotFoundException.class)
    public ResponseResult<Void> handleWorkerInfoNotFoundException(IAddDoctorRotaCommandHandler.WorkerInfoNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - 用户未找到
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdateDoctorRotaCommandHandler.WorkerInfoNotFoundException.class)
    public ResponseResult<Void> handleWorkerInfoNotFoundException(IUpdateDoctorRotaCommandHandler.WorkerInfoNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }


}
