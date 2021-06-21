package com.example.outpatientservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public static ResponseResult<Void> SUCCESS = new ResponseResult<>(10000, "success", null);
}
