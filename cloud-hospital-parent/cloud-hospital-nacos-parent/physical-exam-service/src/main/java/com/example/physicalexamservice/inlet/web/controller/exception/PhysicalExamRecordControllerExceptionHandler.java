package com.example.physicalexamservice.inlet.web.controller.exception;

import com.example.physicalexamservice.inlet.web.controller.PhysicalExamRecordController;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.api.physicalexamrecord.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
@RestControllerAdvice(assignableTypes = PhysicalExamRecordController.class)
public class PhysicalExamRecordControllerExceptionHandler {

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddPhysicalExamRecordCommandHandler.NotFoundPhysicalExamException.class)
    public ResponseResult<Void> handleNotFoundPhysicalExamException(IAddPhysicalExamRecordCommandHandler.NotFoundPhysicalExamException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddPhysicalExamRecordCommandHandler.PhysicalExamStockIsNotEnoughException.class)
    public ResponseResult<Void> handlePhysicalExamStockIsNotEnoughException(IAddPhysicalExamRecordCommandHandler.PhysicalExamStockIsNotEnoughException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryPhysicalExamRecordByIdCommandHandler.PhysicalExamRecordNotFoundException.class)
    public ResponseResult<Void> handlePhysicalExamRecordNotFoundException(IQueryPhysicalExamRecordByIdCommandHandler.PhysicalExamRecordNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler.PhysicalExamRecordNotFoundException.class)
    public ResponseResult<Void> handlePhysicalExamRecordNotFoundException(IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler.PhysicalExamRecordNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdatePhysicalExamRecordPayedCommandHandler.PhysicalExamRecordNotFoundException.class)
    public ResponseResult<Void> handlePhysicalExamRecordNotFoundException(IUpdatePhysicalExamRecordPayedCommandHandler.PhysicalExamRecordNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdatePhysicalExamRecordPayedCommandHandler.PhysicalExamRecordCannotPayException.class)
    public ResponseResult<Void> handlePhysicalExamRecordCannotPayException(IUpdatePhysicalExamRecordPayedCommandHandler.PhysicalExamRecordCannotPayException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    /**
     * 异常处理 - NotFoundPhysicalExamException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryPhysicalExamRecordByNoCommandHandler.PhysicalExamRecordNotFoundException.class)
    public ResponseResult<Void> handlePhysicalExamRecordNotFoundException(IQueryPhysicalExamRecordByNoCommandHandler.PhysicalExamRecordNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }
}
