package com.example.workerservice.service.command.updatepwd;

import com.example.workerservice.adapter.UserDaoAdapter;
import com.example.workerservice.service.api.IUpdateUserPwdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现接口 - IUpdateUserPwdCommandHandler
 */
@Component
@Slf4j
public class UpdateUserPwdCommandHandler implements IUpdateUserPwdCommandHandler {

    /* 构造注入 - 开始 */
    private final UserDaoAdapter userDaoAdapter;

    public UpdateUserPwdCommandHandler(UserDaoAdapter userDaoAdapter) {
        this.userDaoAdapter = userDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(UpdateUserPwdCommand command) {
        /* 去userDaoAdapter查是否有该数据 */
        Boolean flag = null;
        try {
            flag = userDaoAdapter.checkVerifyCode(command.getVerifyCode(), command.getPhone());
        } catch (NullPointerException e) {
            /* 捕获到 NullPointerException 则抛异常 InvalidVerifyCodeException */
            throw new InvalidVerifyCodeException();
        }
        /* 判断flag */
        if (!flag) {
            /* 如果返回false,则抛异常 IncorrectVerifyCodeException 、如果返回true,则什么都不做 */
            throw new IncorrectVerifyCodeException();
        }
    }
}
