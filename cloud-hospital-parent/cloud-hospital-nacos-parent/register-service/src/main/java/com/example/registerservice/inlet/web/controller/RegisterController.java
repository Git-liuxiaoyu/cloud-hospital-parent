package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.service.command.pushphone.PushPhoneGoQueueCommand;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/19:20
 * @Description:
 */
@RestController
public class RegisterController {

    /**
     * @param phone
     * @return
     * 给验证码队列发消息
     */
    @GetMapping("Register/getCode/{phone}")
    public ResponseResult pushPhoneGoQueue(@PathVariable String phone){
        PushPhoneGoQueueCommand command=new PushPhoneGoQueueCommand(phone);
        command.execute();
        return ResponseResult.SUCCESS;
    }

}
