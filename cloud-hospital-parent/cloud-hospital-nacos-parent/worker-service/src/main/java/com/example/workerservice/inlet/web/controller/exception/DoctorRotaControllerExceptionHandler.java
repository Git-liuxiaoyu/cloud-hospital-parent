package com.example.workerservice.inlet.web.controller.exception;

import com.example.workerservice.inlet.web.controller.DoctorRotaController;
import com.example.workerservice.inlet.web.vo.ResponseResult;
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

}
