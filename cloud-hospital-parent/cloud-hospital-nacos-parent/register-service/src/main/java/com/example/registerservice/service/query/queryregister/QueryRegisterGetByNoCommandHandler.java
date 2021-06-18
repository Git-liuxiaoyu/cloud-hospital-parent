package com.example.registerservice.service.query.queryregister;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.service.api.IQueryRegisterGetByNoCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RegisterAdapter adapter;

    @Override
    public RegisterVo action(QueryRegisterGetByNoCommand command) {
        RegisterVo registerVo = adapter.getByNo(command.getNo());
        return registerVo;
    }
}
