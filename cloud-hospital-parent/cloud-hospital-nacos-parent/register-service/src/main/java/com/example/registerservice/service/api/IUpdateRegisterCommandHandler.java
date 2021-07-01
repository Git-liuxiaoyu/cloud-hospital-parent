package com.example.registerservice.service.api;

import com.example.registerservice.service.command.updateregister.UpdateRegisterCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/9:58
 * @Description:
 */
public interface IUpdateRegisterCommandHandler {
    void action(UpdateRegisterCommand command);

    /**
     * 自定义业务异常 - 修改挂号状态失败异常
     **/
    class UpdateRegisterException extends RuntimeException {
        public UpdateRegisterException() {
            super("修改挂号状态失败异常");
        }
    }
}
