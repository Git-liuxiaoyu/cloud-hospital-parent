package com.example.workerservice.inlet.web.controller.exception;

import com.example.workerservice.inlet.web.controller.OutRoomController;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.api.outroom.IQueryOutRoomByIdCommandHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类 - 捕获 - OutRoomControlle
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@RestControllerAdvice(assignableTypes = OutRoomController.class)
public class OutRoomControllerExceptionHandler {

    @ExceptionHandler(value = IQueryOutRoomByIdCommandHandler.OutRoomNotFoundException.class)
    public ResponseResult<Void> handlerOutRoomNotFoundException(IQueryOutRoomByIdCommandHandler.OutRoomNotFoundException e){
        return new ResponseResult<>(444,e.getMessage());
    }

}
