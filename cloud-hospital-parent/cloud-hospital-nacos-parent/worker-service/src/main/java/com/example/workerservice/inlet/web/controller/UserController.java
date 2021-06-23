package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.user.login.LoginUserCommand;
import com.example.workerservice.service.command.user.savelogintoken.SaveLoginTokenByIPCommand;
import com.example.workerservice.service.command.user.sendcode.SendVerifyCodeCommand;
import com.example.workerservice.service.command.user.updatepwd.UpdateUserPwdCommand;
import com.example.workerservice.util.HttpUtil;
import com.example.workerservice.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "登录", notes = "获得[账号]、[密码]来判断是否登录成功,通过请求头获得[请求的IP地址]和[请求登录Token]辅助判断是否重复提交登录表单,登录成功会返还一个登录账号对应的工号信息的Token", produces = "application/json", response = ResponseResult.class)
    public ResponseResult doLogin(@Valid @RequestBody LoginUserCommand command, BindingResult bindingResult, HttpServletRequest request) {
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
        } else {
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
    @ApiOperation(value = "修改密码", notes = "获得[账号]、[密码]来判断是否登录成功,通过请求头获得[请求的IP地址]和[请求登录Token]辅助判断是否重复提交登录表单,登录成功会返还一个登录账号对应的工号信息的Token", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<Void> updatePwd(@Valid @RequestBody UpdateUserPwdCommand command, BindingResult bindingResult, HttpServletRequest request) {

        log.debug("收到命令 [{}]", command);
        /* 判断 rePassword 和 password 值是否相等 */
        if (!command.getRePassword().equals(command.getPassword())) {
            throw new IllegalArgumentException("修改密码失败 | 两次密码输入的不一致");
        }

        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("修改密码失败 | 参数异常");
        }
        /* 执行命令 */
        command.execute();
        /* 返回 */
        return ResponseResult.SUCCESS;
    }


    /**
     * 发送验证码
     *
     * @param command
     * @return
     */
    @PostMapping("send/verify/code")
    @ApiOperation(value = "发送验证码", notes = "通过员工工号找到其手机,向该手机发送验证码", produces = "application/json", response = ResponseResult.class)
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
    @ApiOperation(value = "获得登录请求Token", notes = "每次进入登录页面,获得登录请求Token,以避免登录重复提交表单", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<String> getLoginToken(HttpServletRequest request) {
        /* 获得请求的真实IP地址 */
        String realRequestIP = HttpUtil.getRealRequestIP(request);
        /* 实例化命令,执行命令,返回 */
        return new ResponseResult<>(new SaveLoginTokenByIPCommand(realRequestIP).execute());
    }

}
