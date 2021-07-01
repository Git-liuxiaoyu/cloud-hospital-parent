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
    Register.ById action(QueryRegisterByIdCommand command);

    /**
     * 自定义业务异常 - 根据挂号id查询挂号订单
     **/
    class QueryRegisterByIdException extends RuntimeException {
        public QueryRegisterByIdException() {
            super("根据挂号id没有查询到挂号订单");
        }
    }
}
