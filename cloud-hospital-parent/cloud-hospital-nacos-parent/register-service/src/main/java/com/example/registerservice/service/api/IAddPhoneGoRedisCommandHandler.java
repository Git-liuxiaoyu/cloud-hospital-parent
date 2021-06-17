package com.example.registerservice.service.api;

import com.example.registerservice.service.command.addphone.AddPhoneGoRedisCommandHandler;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/14:52
 * @Description:
 */
public interface IAddPhoneGoRedisCommandHandler {
    boolean action(PushPhoneGoQueueCommand command);
}
