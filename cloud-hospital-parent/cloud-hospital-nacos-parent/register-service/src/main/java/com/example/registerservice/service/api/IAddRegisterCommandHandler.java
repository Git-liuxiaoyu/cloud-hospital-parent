package com.example.registerservice.service.api;


import com.example.registerservice.service.command.addRegister.AddRegisterCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:13
 * @Description: 新增病人接口
 */
public interface IAddRegisterCommandHandler {
    void action(AddRegisterCommand command);
}
