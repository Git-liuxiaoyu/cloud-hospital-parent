package com.example.registerservice.inlet.web.controller;


import com.example.registerservice.service.command.addRegister.AddRegisterCommand;
import com.example.registerservice.service.command.addphone.AddPhoneGoQueueCommand;
import com.example.registerservice.service.command.updateregister.UpdateRegisterCommand;
import com.example.registerservice.service.query.queryphoneandcode.QueryPhoneAndCodeCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterByIdCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterByPhoneCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterGetByNoCommand;
import com.example.registerservice.service.query.queryregister.po.Register;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;
import com.example.registerservice.util.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/19:20
 * @Description: 挂号controller
 */
@CrossOrigin
@RestController
@Api(value = "挂号服务", description = "用户操作 API")
@ApiModel
public class RegisterController {
    /**
     * @param phone
     * @return 给验证码队列发消息
     */
    @ApiOperation(value = "验证码队列", notes = "给验证码队列发消息",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号",
                    example = "17683858973", required = true, dataType = "String", paramType = "path")
    })
    @PostMapping("Register/getCode/{phone}")
    public ResponseResult pushPhoneGoQueue(@PathVariable String phone) {
        /*执行发送手机号到队列的方法*/
        new AddPhoneGoQueueCommand(phone).execute();
        return ResponseResult.SUCCESS;
    }

    /**
     * 登入表单验证
     *
     * @param command
     * @return
     */
    @ApiOperation(value = "登入", notes = "登入表单验证",
            produces = "application/json", response = ResponseResult.class)
    @PostMapping("Register/doLogin")
    public ResponseResult doLogin(@RequestBody QueryPhoneAndCodeCommand command) {
        /*执行判断验证码是否可以匹配*/
        command.execute();
        return ResponseResult.SUCCESS;
    }

    /**
     * 根据挂号编号查询数据
     *
     * @param no
     * @return
     */
    @ApiOperation(value = "根据挂号编号No查询数据", notes = "根据挂号编号No查询数据",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "挂号编号",
                    example = "GH20210622102208869988203", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("Register/queryRegister/getByNo/{no}")
    public ResponseResult<Register.ByNo> queryRegisterGetByNo(@PathVariable("no") String no) {
        return new ResponseResult(new QueryRegisterGetByNoCommand(no).execute());
    }

    /**
     * 根据id修改挂号的状态
     *
     * @param id
     * @param status
     * @return
     */
    @ApiOperation(value = "修改挂号的状态", notes = "根据id修改挂号的状态",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "挂号id",
                    example = "13", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "挂号状态",
                    example = "0", required = true, dataType = "String", paramType = "path")
    })
    @PostMapping("/Register/update/status/{id}/{status}")
    public ResponseResult updateStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        new UpdateRegisterCommand(id, status).execute();
        return ResponseResult.SUCCESS;
    }

    /**
     * 添加挂号订单
     *
     * @param command
     * @return
     */
    @ApiOperation(value = "添加挂号订单", notes = "添加挂号订单",
            produces = "application/json", response = ResponseResult.class)
    @PostMapping("/Register/add")
    public ResponseResult registerAdd(@RequestBody AddRegisterCommand command) {
        command.execute();
        return ResponseResult.SUCCESS;
    }

    /**
     * 根据挂号的手机号phone查询挂号的订单
     *
     * @param phone
     * @return
     */
    @ApiOperation(value = "根据挂号的手机号phone查询挂号信息", notes = "根据挂号的手机号phone查询挂号的订单",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "挂号手机号",
                    example = "17683858973", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("/Register/query/phone/{phone}")
    public ResponseResult<RegisterServicePo> findAll(@PathVariable("phone") String phone) {
        return new ResponseResult(new QueryRegisterByPhoneCommand(phone).execute());
    }

    /**
     * 根据挂号id查询挂号详细信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据挂号id查询挂号详细信息", notes = "根据挂号id查询挂号详细信息",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "挂号id",
                    example = "11", required = true, dataType = "Long", paramType = "path")
    })
    @GetMapping("/Register/query/byId/{id}")
    public ResponseResult<Register.ById> getByIdVoResponseResult(@PathVariable("id") Long id) {
        return new ResponseResult(new QueryRegisterByIdCommand(id).execute());
    }
}
