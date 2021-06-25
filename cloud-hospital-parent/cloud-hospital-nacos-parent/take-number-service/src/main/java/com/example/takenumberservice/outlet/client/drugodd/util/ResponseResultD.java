package com.example.takenumberservice.outlet.client.drugodd.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ResponseResultD<T> {
    @ApiModelProperty(value = "响应状态码", example = "200")
    private int code;
    @ApiModelProperty(value = "响应状态信息", example = "success")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public static ResponseResultD<Void> SUCCESS = new ResponseResultD<>(10000, "success", null);
}
