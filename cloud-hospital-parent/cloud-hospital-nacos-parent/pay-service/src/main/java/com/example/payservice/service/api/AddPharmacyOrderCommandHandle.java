package com.example.payservice.service.api;


import com.example.payservice.service.command.pharmacyPay.addpharmacypay.AddPharmacyOrderCommand;
import com.example.payservice.util.ResponseResult;

public interface AddPharmacyOrderCommandHandle {

    /**
     * 添加进数据库
     * @param addCallOrderCommand
     * @return
     */
    public ResponseResult<AddPharmacyOrderCommand> execute(AddPharmacyOrderCommand addCallOrderCommand);
}
