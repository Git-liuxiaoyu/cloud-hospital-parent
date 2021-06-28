package com.example.payservice.service.api;


import com.example.payservice.service.command.CallProofPay.addcallorder.AddCallOrderCommand;
import com.example.payservice.util.ResponseResult;

public interface AddCallOrderCommandHandle {

    /**
     * 添加进数据库
     * @param addCallOrderCommand
     * @return
     */
    public ResponseResult<AddCallOrderCommand> execute(AddCallOrderCommand addCallOrderCommand);

}
