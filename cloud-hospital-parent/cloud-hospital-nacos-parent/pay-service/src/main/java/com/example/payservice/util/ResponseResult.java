package com.example.payservice.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseResult<T> {
    @ApiModelProperty(value="状态码",required = true,example = "200")
    private int code;
    @ApiModelProperty(value="返回的消息",required = true,example = "执行成功")
    private String msg;
    @ApiModelProperty(value="返回的泛型参数",required = true,example = "ProofController")
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this(200, "OK");
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static final ResponseResult<Void> SUCCESS = new ResponseResult<>(200, "OK");
    public static final ResponseResult<Void> NOTLOGINED = new ResponseResult<>(401, "未登录");
    public static final ResponseResult<Void> FORBIDDEN = new ResponseResult<>(403, "无权限");
    public static final ResponseResult<Void> FAIL = new ResponseResult<>(500, "操作失败");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
