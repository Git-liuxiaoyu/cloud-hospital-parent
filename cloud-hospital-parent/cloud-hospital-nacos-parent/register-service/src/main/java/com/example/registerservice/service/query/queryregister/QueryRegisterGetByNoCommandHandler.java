package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.service.api.IQueryRegisterGetByNoCommandHandler;
import com.example.registerservice.service.query.queryregister.po.Register;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/18:27
 * @Description:
 */
@Component
public class QueryRegisterGetByNoCommandHandler implements IQueryRegisterGetByNoCommandHandler {

    private final RegisterAdapter adapter;

    public QueryRegisterGetByNoCommandHandler(RegisterAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Register.ByNo action(QueryRegisterGetByNoCommand command) {
        Register.ByNo byNo = null;
        try {
            byNo = adapter.getByNo(command.getNo());
        } catch (NullPointerException e) {
            throw new QueryRegisterGetByNoException();
        }
        return byNo;
    }
}
