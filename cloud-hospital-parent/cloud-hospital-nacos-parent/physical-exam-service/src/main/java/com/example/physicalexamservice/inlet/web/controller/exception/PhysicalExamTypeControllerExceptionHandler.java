package com.example.physicalexamservice.inlet.web.controller.exception;

import com.example.physicalexamservice.inlet.web.controller.PhysicalExamTypeController;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.api.physicalexamtype.IAddPhysicalExamTypeCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@RestControllerAdvice(assignableTypes = PhysicalExamTypeController.class)
public class PhysicalExamTypeControllerExceptionHandler {

    /**
     * 异常处理 - PhysicalExamTypeNameRepeatedException
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = IAddPhysicalExamTypeCommandHandler.PhysicalExamTypeNameRepeatedException.class)
    public ResponseResult<Void> handlePhysicalExamTypeNameRepeatedException(IAddPhysicalExamTypeCommandHandler.PhysicalExamTypeNameRepeatedException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

}
