package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResponseResult<T> {
    @ApiModelProperty(value = "响应状态码", example = "200")
    private int code; // 状态码 200,成功，500:失败，403：无权
    @ApiModelProperty(value = "响应状态信息", example = "success")
    private String msg; // 消息
    @ApiModelProperty(value = "响应数据")
    private T data; // 数据

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
    public static final ResponseResult<Void> REPEAT = new ResponseResult<>(444, "页面失效,请刷新页面后再试");

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
