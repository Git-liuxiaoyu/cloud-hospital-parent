package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.user.login.LoginUserCommand;
import com.example.workerservice.service.command.user.savelogintoken.SaveLoginTokenByIPCommand;
import com.example.workerservice.service.command.user.sendcode.SendVerifyCodeCommand;
import com.example.workerservice.service.command.user.updatepwd.UpdateUserPwdCommand;
import com.example.workerservice.util.HttpUtil;
import com.example.workerservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 控制器类 - 用户控制器
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    /**
     * 登录方法
     *
     * @param command
     * @return
     */
    @PostMapping("doLogin")
    public ResponseResult doLogin(@Valid @RequestBody LoginUserCommand command, BindingResult bindingResult,HttpServletRequest request) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("登录失败 | 参数异常");
        }
        /* 获得 IP 地址 */
        String realRequestIP = HttpUtil.getRealRequestIP(request);
        /* 存入IP */
        command.setIp(realRequestIP);
        /* 判断是否存在该IP再Redis中是否存在该Token,存在则继续下去 */
        if (command.check()) {
            /* 执行命令,返回返回值 */
            return new ResponseResult<>(JwtUtil.creatSign(command.execute()));
        }else{
            /* 不存再该Token,说明重复请求.不进行处理 */
            return ResponseResult.REPEAT;
        }
    }

    /**
     * 修改密码
     *
     * @param command
     * @return
     */
    @PostMapping("update/pwd")
    public ResponseResult<Void> updatePwd(@Valid @RequestBody UpdateUserPwdCommand command, BindingResult bindingResult, HttpServletRequest request) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("修改密码失败 | 参数异常");
        }
        /* 执行命令 */
        command.execute();
        return ResponseResult.SUCCESS;
    }


    /**
     * 发送验证码
     *
     * @param command
     * @return
     */
    @PostMapping("send/verify/code")
    public ResponseResult<Void> verify(@Valid @RequestBody SendVerifyCodeCommand command, BindingResult bindingResult) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取验证码失败 | 参数异常");
        }
        /* 执行命令 */
        command.execute();
        /* 返回成功消息 */
        return ResponseResult.SUCCESS;
    }


    /**
     * 获得登录页码 Token
     *
     * @return
     */
    @GetMapping("login/token")
    public ResponseResult<String> getLoginToken(HttpServletRequest request) {
        /* 获得请求的真实IP地址 */
        String realRequestIP = HttpUtil.getRealRequestIP(request);
        /* 实例化命令,执行命令,返回 */
        return new ResponseResult<>(new SaveLoginTokenByIPCommand(realRequestIP).execute());
    }

}
