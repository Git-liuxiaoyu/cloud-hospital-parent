package com.example.registerservice.service.api;

import com.example.registerservice.service.query.queryregister.QueryRegisterByPhoneCommand;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/23:27
 * @Description:
 */
public interface IQueryRegisterByPhoneCommandHandler {
    List<RegisterServicePo> action(QueryRegisterByPhoneCommand command);
}
