package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.service.api.IQueryRegisterByIdCommandHandler;
import com.example.registerservice.service.query.queryregister.po.Register;
import com.example.registerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/17:40
 * @Description:
 */
@Data
public class QueryRegisterByIdCommand {

    private Long id;
    private IQueryRegisterByIdCommandHandler handler;

    public QueryRegisterByIdCommand(Long id) {
        this();
        this.id = id;
    }

    public QueryRegisterByIdCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryRegisterByIdCommandHandler.class);
    }

    public Register.ById execute() {
        Register.ById action = handler.action(this);
        return action;
    }

}
