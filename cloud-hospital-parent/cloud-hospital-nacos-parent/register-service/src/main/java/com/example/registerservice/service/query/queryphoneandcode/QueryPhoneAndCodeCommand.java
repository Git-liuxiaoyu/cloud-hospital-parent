package com.example.registerservice.service.query.queryphoneandcode;

import com.example.registerservice.service.api.IQueryPhoneAndCodeCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/17:19
 * @Description:
 */
@Data
public class QueryPhoneAndCodeCommand implements Serializable {
    private String phone;//电话
    private String code;//验证码

    private IQueryPhoneAndCodeCommandHandler handler;

    public QueryPhoneAndCodeCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryPhoneAndCodeCommandHandler.class);
    }

    public boolean execute() {
        //返回的是true表示表单验证通过 false取反
        boolean action = handler.action(this);
        return action;
    }

}
