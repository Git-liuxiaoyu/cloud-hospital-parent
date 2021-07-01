package com.example.registerservice.service.api;


import com.example.registerservice.service.command.addRegister.AddRegisterCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:13
 * @Description: 新增挂号订单接口
 */
public interface IAddRegisterCommandHandler {
    void action(AddRegisterCommand command);

    /**
     * 自定义业务异常 - 根据挂号no没有查询到挂号信息
     **/
    class AddRegisterException extends RuntimeException {
        public AddRegisterException() {
            super("新增挂号订单失败");
        }
    }
}
