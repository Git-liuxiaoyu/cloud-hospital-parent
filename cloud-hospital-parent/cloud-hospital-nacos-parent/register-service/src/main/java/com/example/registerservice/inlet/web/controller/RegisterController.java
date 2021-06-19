package com.example.registerservice.inlet.web.controller;


import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.query.queryphoneandcode.QueryPhoneAndCodeCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterGetByNoCommand;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;
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

    /**
     * 登入表单验证
     *
     * @param command
     * @return
     */
    @PostMapping("Register/doLogin")
    public ResponseResult doLogin(@RequestBody QueryPhoneAndCodeCommand command) {
        boolean execute = command.execute();
        if (execute) {
            return ResponseResult.SUCCESS;
        }
        return new ResponseResult(7002, "验证码有误");
    }

    /**
     * 根据挂号编号查询数据
     *
     * @param no
     * @return
     */
    @GetMapping("Register/queryRegister/getByNo/{no}")
    public ResponseResult<SubjectVo> queryRegisterGetByNo(@PathVariable("no") String no) {
        QueryRegisterGetByNoCommand command = new QueryRegisterGetByNoCommand(no);
        RegisterVo execute = null;
        try {
            execute = command.execute();
        } catch (Exception e) {
            return new ResponseResult<>(444,"");
        }
        return new ResponseResult(execute);
    }
}
