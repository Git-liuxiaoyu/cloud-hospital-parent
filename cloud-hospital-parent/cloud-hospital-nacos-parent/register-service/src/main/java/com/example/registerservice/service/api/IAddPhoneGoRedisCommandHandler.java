package com.example.registerservice.service.api;

import com.example.registerservice.service.command.addphone.AddPhoneGoQueueCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/14:52
 * @Description: 将手机号存redis的接口
 */
public interface IAddPhoneGoRedisCommandHandler {
    void action(AddPhoneGoQueueCommand command);

    /**
     * 自定义业务异常 - 该手机号今天已发送过验证码
     **/
    class AddPhoneGoRedisException extends RuntimeException {
        public AddPhoneGoRedisException() {
            super("该手机号今天已发送过验证码");
        }
    }
}
