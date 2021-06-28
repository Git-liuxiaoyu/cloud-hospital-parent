package com.example.payservice.service.api;

import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.util.ResponseResult;


public interface RefundCallProofCommandHandle {

    /**
     * 挂号退款
     * @return
     */
    ResponseResult<Void> CallProofrefund(RefundCallProofCommand refundCallProofCommand);
}
