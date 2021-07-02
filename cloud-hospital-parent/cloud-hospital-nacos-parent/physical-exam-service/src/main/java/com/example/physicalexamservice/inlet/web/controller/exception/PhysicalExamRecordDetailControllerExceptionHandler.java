package com.example.physicalexamservice.inlet.web.controller.exception;

import com.example.physicalexamservice.inlet.web.controller.PhysicalExamRecordDetailController;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.api.physicalexamrecorddetail.IUpdatePhysicalExamRecordDetailCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@RestControllerAdvice(assignableTypes = PhysicalExamRecordDetailController.class)
public class PhysicalExamRecordDetailControllerExceptionHandler {

    /**
     * 异常处理 - PhysicalExamTypeNameRepeatedException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseResult<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseResult<>(444, e.getMessage());
    }


    /**
     * 异常处理 - PhysicalExamTypeNameRepeatedException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IUpdatePhysicalExamRecordDetailCommandHandler.NotFoundPhysicalExamRecordException.class)
    public ResponseResult<Void> handleNotFoundPhysicalExamRecordException(IUpdatePhysicalExamRecordDetailCommandHandler.NotFoundPhysicalExamRecordException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

}
