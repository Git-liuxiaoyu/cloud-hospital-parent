package com.example.registerservice.service.query.queryphoneandcode;

import com.example.registerservice.service.api.IQueryPhoneAndCodeCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/17:19
 * @Description:
 */
@Data
@ApiModel
public class QueryPhoneAndCodeCommand implements Serializable {

    @NotNull
    @ApiModelProperty(value = "电话号", example = "17683858973", required = true)
    private String phone;//电话

    @NotNull
    @ApiModelProperty(value = "验证码", example = "280517", required = true)
    private String code;//验证码

    @ApiModelProperty(hidden = true)
    private IQueryPhoneAndCodeCommandHandler handler;

    public QueryPhoneAndCodeCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryPhoneAndCodeCommandHandler.class);
    }

    public void execute() {
        handler.action(this);
    }

}
