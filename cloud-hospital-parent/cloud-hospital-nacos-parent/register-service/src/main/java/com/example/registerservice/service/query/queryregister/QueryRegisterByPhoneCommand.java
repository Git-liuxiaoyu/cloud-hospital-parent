package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.service.api.IQueryRegisterByPhoneCommandHandler;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/23:27
 * @Description:
 */
@Data
public class QueryRegisterByPhoneCommand {
    private String phone;

    private IQueryRegisterByPhoneCommandHandler handler;

    public QueryRegisterByPhoneCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryRegisterByPhoneCommandHandler.class);
    }

    public QueryRegisterByPhoneCommand(String phone) {
        this();
        this.phone=phone;
    }

    public List<RegisterServicePo> execute() {
        List<RegisterServicePo> action = handler.action(this);
        return action;
    }
}
