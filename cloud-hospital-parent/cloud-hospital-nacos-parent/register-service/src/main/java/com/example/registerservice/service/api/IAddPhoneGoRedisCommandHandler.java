package com.example.registerservice.service.api;

import com.example.registerservice.service.command.addphone.AddPhoneGoRedisCommandHandler;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/14:52
 * @Description: 将手机号存redis的接口
 */
public interface IAddPhoneGoRedisCommandHandler {
    boolean action(PushPhoneGoQueueCommand command);
}
