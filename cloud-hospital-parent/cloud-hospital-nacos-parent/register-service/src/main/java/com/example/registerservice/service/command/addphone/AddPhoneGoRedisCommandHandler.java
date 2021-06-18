package com.example.registerservice.service.command.addphone;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.service.api.IAddPhoneGoRedisCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/14:56
 * @Description:
 */
@Component
@Slf4j
public class AddPhoneGoRedisCommandHandler implements IAddPhoneGoRedisCommandHandler {

    @Autowired
    private RegisterAdapter daoAdapter;

    @Override
    public boolean action(PushPhoneGoQueueCommand command) {
        try {
            //如果为null就抛异常
            daoAdapter.select(command);
            log.debug("该{}手机号今天已获取验证码！", command.getPhone());
        } catch (Exception e) {
            log.debug("该{}手机号今天没有获取验证码！", command.getPhone());
            //将手机号添加redis
            daoAdapter.addPhoneGoRedis(command);
            return false;
        }
        return true;
    }
}
