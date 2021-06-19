package com.example.takenumberservice.adapter.Exception;

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
