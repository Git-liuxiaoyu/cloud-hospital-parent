package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.service.api.IQueryRegisterGetByNoCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/18:27
 * @Description:
 */
@Data
public class QueryRegisterGetByNoCommand implements Serializable {

    private String no;

    private IQueryRegisterGetByNoCommandHandler handler;

    public QueryRegisterGetByNoCommand(String no) {
        this();
        this.no = no;
    }

    public QueryRegisterGetByNoCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryRegisterGetByNoCommandHandler.class);
    }

    public RegisterVo execute() {
        RegisterVo action = handler.action(this);
        return action;
    }
}
