package com.example.workerservice.service.api;

import com.example.workerservice.service.command.updatepwd.UpdateUserPwdCommand;

/**
 * 接口 - 修改用户密码
 */
public interface IUpdateUserPwdCommandHandler {

    void action(UpdateUserPwdCommand command);


    /**
     * 自定义业务异常 - 验证码错误
     **/
    class IncorrectVerifyCodeException extends RuntimeException {
        public IncorrectVerifyCodeException() {
            super("输入的验证码错误");
        }
    }

    /**
     * 自定义业务异常 - 验证码错误
     **/
    class InvalidVerifyCodeException extends RuntimeException {
        public InvalidVerifyCodeException() {
            super("验证码不存在,请重新获取");
        }
    }

    /**
     * 自定义业务异常 - 用户未发现
     **/
    class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("账号或密码错误");
        }
    }

}
