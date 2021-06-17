package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.login.LoginUserCommand;
import com.example.workerservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult<String> doLogin(@Valid @RequestBody LoginUserCommand command, BindingResult bindingResult) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("登录失败 | 参数异常");
        }
        /* 执行命令,返回返回值 */
        return new ResponseResult<>(JwtUtil.creatSign(command.execute()));
    }



//    /**
//     * 获得登录IP
//     *
//     * @return
//     */
//    @GetMapping("login/token")
//    public String getLoginToken(HttpServletRequest request) {
//
//
//    }

}
