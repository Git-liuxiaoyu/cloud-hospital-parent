package com.example.registerservice.inlet.web.controller;


import com.example.registerservice.adapter.converter.RegisterConverter;
import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.command.addRegister.AddRegisterCommand;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;
import com.example.registerservice.service.command.updateregister.UpdateRegisterCommand;
import com.example.registerservice.service.query.queryphoneandcode.QueryPhoneAndCodeCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterByIdCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterByPhoneCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterGetByNoCommand;
import com.example.registerservice.service.query.queryregister.po.Register;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;
import com.example.registerservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/19:20
 * @Description: 挂号controller
 */
@CrossOrigin
@RestController
public class RegisterController {

    @Autowired
    private RegisterConverter converter;

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
            return new ResponseResult<>(444, "");
        }
        return new ResponseResult(execute);
    }

    /**
     * 根据id修改挂号的状态
     *
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/Register/update/status/{id}/{status}")
    public ResponseResult updateStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        UpdateRegisterCommand command = new UpdateRegisterCommand(id, status);
        try {
            command.execute();
        } catch (Exception e) {
            return new ResponseResult(444, "");
        }
        return ResponseResult.SUCCESS;
    }

    /**
     * 添加挂号订单
     *
     * @param vo
     * @return
     */
    @PostMapping("/Register/add")
    public ResponseResult registerAdd(@RequestBody RegisterVo.AddRegisterVo vo) {
        AddRegisterCommand command = new AddRegisterCommand(vo);
        try {
            command.execute();
        } catch (Exception e) {
            return new ResponseResult(444, "");
        }
        return ResponseResult.SUCCESS;
    }

    /**
     * 根据挂号的手机号查询挂号的订单
     *
     * @param phone
     * @return
     */
    @GetMapping("/Register/query/phone/{phone}")
    public ResponseResult<RegisterServicePo> findAll(@PathVariable("phone") String phone) {
        QueryRegisterByPhoneCommand command = new QueryRegisterByPhoneCommand(phone);
        List<RegisterServicePo> execute = command.execute();
        return new ResponseResult(execute);
    }

    /**
     * 根据挂号id查询挂号详细信息
     *
     * @param id
     * @return
     */
    @GetMapping("/Register/query/byId/{id}")
    public ResponseResult<RegisterVo.QueryGetByIdVo> getByIdVoResponseResult(@PathVariable("id") Long id) {
        QueryRegisterByIdCommand command = new QueryRegisterByIdCommand(id);
        Register execute = null;
        try {
            execute = command.execute();
        } catch (Exception e) {
            return new ResponseResult<>(444, "");
        }
        RegisterVo.QueryGetByIdVo converter = this.converter.converter(execute);
        return new ResponseResult(converter);
    }
}
