package com.example.workerservice.service.api;

import com.example.workerservice.service.command.login.LoginUserCommand;

/**
 * 接口 - 用户登录命令
 */
public interface ILoginUserCommandHandler {

   String action(LoginUserCommand command);

   /**
    * 自定义业务异常 - 用户未发现
    **/
   class UserNotFoundException extends RuntimeException {
      public UserNotFoundException() {
         super("账号或密码错误");
      }
   }

}
