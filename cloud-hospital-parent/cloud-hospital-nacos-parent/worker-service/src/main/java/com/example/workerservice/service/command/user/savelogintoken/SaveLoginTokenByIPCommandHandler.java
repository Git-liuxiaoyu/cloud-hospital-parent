package com.example.workerservice.service.command.user.savelogintoken;

import com.example.workerservice.adapter.UserDaoAdapter;
import com.example.workerservice.service.api.user.ISaveLoginTokenByIPCommandHandler;
import com.example.workerservice.util.CreateRandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - ISaveLoginTokenByIPCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class SaveLoginTokenByIPCommandHandler implements ISaveLoginTokenByIPCommandHandler {

    /* 构造注入 - BEGIN */
    private final UserDaoAdapter userDaoAdapter;

    public SaveLoginTokenByIPCommandHandler(UserDaoAdapter userDaoAdapter) {
        this.userDaoAdapter = userDaoAdapter;
    }
    /* 构造注入 - END */

    @Override
    public String action(SaveLoginTokenByIPCommand command) {
        /* 获得一个随机 Token */
        String randomLoginToken = CreateRandomUtil.createRandomLoginToken(30);
        /* LOG */
        log.debug("IP [{}] 获得了登录 Token [{}]",command.getIp(),randomLoginToken);
        /* 调用方法 */
        userDaoAdapter.saveLoginToken(command.getIp(),randomLoginToken);
        /* 返回 */
        return randomLoginToken;
    }
}
