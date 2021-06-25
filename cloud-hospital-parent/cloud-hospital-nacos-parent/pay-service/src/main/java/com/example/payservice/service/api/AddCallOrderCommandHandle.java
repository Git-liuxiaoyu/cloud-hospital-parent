package com.example.payservice.service.api;


import com.example.payservice.inlet.web.controller.vo.CallProofPayVo;
import com.example.payservice.service.command.addcallorder.AddCallOrderCommand;
import com.example.payservice.util.ResponseResult;

public interface AddCallOrderCommandHandle {

    /**
     * 添加进数据库
     * @param addCallOrderCommand
     * @return
     */
    public ResponseResult<AddCallOrderCommand> execute(AddCallOrderCommand addCallOrderCommand);

}
