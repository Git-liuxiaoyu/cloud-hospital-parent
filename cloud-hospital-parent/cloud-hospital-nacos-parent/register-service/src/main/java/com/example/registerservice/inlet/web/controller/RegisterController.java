package com.example.registerservice.inlet.web.controller;


import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;
import com.example.registerservice.service.query.GetPhoneAndCode.QueuePhoneAndCodeCommand;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/19:20
 * @Description:
 */
@CrossOrigin
@RestController
public class RegisterController {

    /**
     * @param phone
     * @return 给验证码队列发消息
     */
    @PostMapping("Register/getCode/{phone}")
    public ResponseResult pushPhoneGoQueue(@PathVariable String phone) {
        PushPhoneGoQueueCommand command = new PushPhoneGoQueueCommand(phone);
        boolean execute = command.execute();
        if (execute) {
            return new ResponseResult(7001, "今天已获取验证码，无法发送");
        }
        return ResponseResult.SUCCESS;
    }

    @PostMapping("Register/doLogin")
    public ResponseResult doLogin(@RequestBody QueuePhoneAndCodeCommand command) {
        boolean execute = command.execute();
        if (execute) {
            return ResponseResult.SUCCESS;
        }
        return new ResponseResult(7002, "验证码有误");
    }
}
