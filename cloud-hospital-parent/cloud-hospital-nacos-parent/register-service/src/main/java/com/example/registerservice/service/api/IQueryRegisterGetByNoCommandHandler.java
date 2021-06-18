package com.example.registerservice.service.api;

import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.service.query.queryregister.QueryRegisterGetByNoCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/14:52
 * @Description: 将手机号存redis的接口
 */
public interface IQueryRegisterGetByNoCommandHandler {
    RegisterVo action(QueryRegisterGetByNoCommand command);
}
