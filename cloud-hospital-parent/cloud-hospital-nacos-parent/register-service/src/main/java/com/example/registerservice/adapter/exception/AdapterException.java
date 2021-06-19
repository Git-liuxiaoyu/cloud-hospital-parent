package com.example.registerservice.adapter.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/11:05
 * @Description: 自定义Adapter层的异常
 */
public class AdapterException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AdapterException() {}

    public AdapterException(String msg) {
        super(msg);
    }

    public AdapterException(Throwable cause) {
        super(cause);
    }

    public AdapterException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
