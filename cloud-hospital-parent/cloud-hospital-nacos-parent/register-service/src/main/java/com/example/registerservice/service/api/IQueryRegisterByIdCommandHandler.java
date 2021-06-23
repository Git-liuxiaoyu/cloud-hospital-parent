package com.example.registerservice.service.api;


import com.example.registerservice.service.query.queryregister.QueryRegisterByIdCommand;
import com.example.registerservice.service.query.queryregister.po.Register;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:13
 * @Description: 新增病人接口
 */
public interface IQueryRegisterByIdCommandHandler {
    Register action(QueryRegisterByIdCommand command);
}
