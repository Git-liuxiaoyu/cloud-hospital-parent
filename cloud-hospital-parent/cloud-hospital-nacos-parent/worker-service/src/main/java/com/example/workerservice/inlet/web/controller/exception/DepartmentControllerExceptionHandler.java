package com.example.workerservice.inlet.web.controller.exception;

import com.example.workerservice.inlet.web.controller.DepartmentContrller;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.api.department.IQueryAllDepartmentByDivisionIdCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理 - DepartmentController
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/25
 */
@RestControllerAdvice(assignableTypes = DepartmentContrller.class)
public class DepartmentControllerExceptionHandler {

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseResult<Void> handleNumberFormatException(NumberFormatException e) {
        return new ResponseResult<>(444, e.getMessage());
    }

    @ExceptionHandler(value = IQueryAllDepartmentByDivisionIdCommandHandler.DivisionNotFoundException.class)
    public ResponseResult<Void> handleDivisionNotFoundException(IQueryAllDepartmentByDivisionIdCommandHandler.DivisionNotFoundException e) {
        return new ResponseResult<>(444, e.getMessage());
    }



}
