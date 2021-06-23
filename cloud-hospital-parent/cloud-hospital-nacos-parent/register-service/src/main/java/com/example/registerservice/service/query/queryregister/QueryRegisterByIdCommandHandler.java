package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.service.api.IQueryRegisterByIdCommandHandler;
import com.example.registerservice.service.query.queryregister.po.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/17:40
 * @Description:
 */
@Component
public class QueryRegisterByIdCommandHandler implements IQueryRegisterByIdCommandHandler {

    @Autowired
    private RegisterAdapter adapter;

    @Override
    public Register action(QueryRegisterByIdCommand command) {
        Register register = adapter.selectById(command);
        return register;
    }
}
