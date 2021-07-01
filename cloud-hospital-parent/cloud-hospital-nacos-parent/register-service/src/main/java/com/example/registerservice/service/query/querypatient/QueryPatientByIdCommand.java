package com.example.registerservice.service.query.querypatient;

import com.example.registerservice.service.api.IQueryPatientByIdCommandHandler;
import com.example.registerservice.service.query.querypatient.domain.Patient;
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
 * @Date: 2021/06/22/16:48
 * @Description: 根据id查询患者信息命令类
 */

@Data
@ApiModel
public class QueryPatientByIdCommand {

    /*患者Id*/
    @NotNull
    @ApiModelProperty(value = "患者id", example = "38", required = true)
    private Long id;

    /*注入对象*/
    @ApiModelProperty(hidden = true)
    private IQueryPatientByIdCommandHandler handler;

    /*有参注入*/
    public QueryPatientByIdCommand(Long id) {
        this();
        this.id = id;
    }

    /*无参构造*/
    public QueryPatientByIdCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryPatientByIdCommandHandler.class);
    }

    /*命令方法*/
    public Patient execute() {
        Patient action = handler.action(this);
        return action;
    }
}
