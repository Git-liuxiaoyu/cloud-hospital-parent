package com.example.workerservice.inlet.web.controller.exception;

import com.example.workerservice.inlet.web.controller.WorkerInfoController;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoByIdCommandHandler;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoByNoCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类 - 处理 - WorkerInfoController
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@RestControllerAdvice(assignableTypes = WorkerInfoController.class)
public class WorkerInfoControllerExceptionHandler {

    /**
     * 处理异常 - 处理员工未找到
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryWorkerInfoByIdCommandHandler.WorkerInfoNotFoundException.class)
    public ResponseResult<Void> handleWorkerInfoNotFoundException(IQueryWorkerInfoByIdCommandHandler.WorkerInfoNotFoundException e){
        return new ResponseResult<>(444,e.getMessage());
    }

    /**
     * 处理异常 - 处理员No找到
     * @param e
     * @return
     */
    @ExceptionHandler(value = IQueryWorkerInfoByNoCommandHandler.WorkerInfoNotFoundException.class)
    public ResponseResult<Void> handleWorkerInfoNotFoundException(IQueryWorkerInfoByNoCommandHandler.WorkerInfoNotFoundException e){
        return new ResponseResult<>(444,e.getMessage());
    }

}
