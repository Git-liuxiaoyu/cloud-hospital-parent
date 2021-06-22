package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.service.api.IQueryRegisterByPhoneCommandHandler;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/23:27
 * @Description:
 */
@Component
public class QueryRegisterByPhoneCommandHandler implements IQueryRegisterByPhoneCommandHandler {

    @Autowired
    private RegisterAdapter adapter;

    @Override
    public List<RegisterServicePo> action(QueryRegisterByPhoneCommand command) {
        List<RegisterServicePo> select = adapter.select(command);
        return select;
    }
}
