package com.example.workerservice.service.command.user.login;

import com.example.workerservice.adapter.UserDaoAdapter;
import com.example.workerservice.service.api.user.ILoginUserCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 用户登录命令处理器
 */
@Slf4j
@Component
public class LoginUserCommandHandler implements ILoginUserCommandHandler {

    /* 构造注入 - 开始 */
    private final UserDaoAdapter userDaoAdapter;

    public LoginUserCommandHandler(UserDaoAdapter userDaoAdapter) {
        this.userDaoAdapter = userDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public String action(LoginUserCommand command) {
        try {
            /* 执行方法,捕获异常则抛自定义异常 */
            return userDaoAdapter.login(command.getAccount(), command.getPassword());
        } catch (NullPointerException e) {
            throw new UserNotFoundException();
        }
    }
}
