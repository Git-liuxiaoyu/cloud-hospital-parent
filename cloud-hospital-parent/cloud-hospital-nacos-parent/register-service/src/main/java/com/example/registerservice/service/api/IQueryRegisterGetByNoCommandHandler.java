package com.example.registerservice.service.api;

import com.example.registerservice.service.query.queryregister.QueryRegisterGetByNoCommand;
import com.example.registerservice.service.query.queryregister.po.Register;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/14:52
 * @Description:
 */
public interface IQueryRegisterGetByNoCommandHandler {
    Register.ByNo action(QueryRegisterGetByNoCommand command);

    /**
     * 自定义业务异常 - 根据挂号no没有查询到挂号信息
     **/
    class QueryRegisterGetByNoException extends RuntimeException {
        public QueryRegisterGetByNoException() {
            super("根据挂号no没有查询到挂号信息");
        }
    }
}
