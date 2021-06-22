package com.example.outpatientservice.inlet.web.exception;

public class WebException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public WebException() {}

    public WebException(String msg) {
        super(msg);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

    public WebException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
