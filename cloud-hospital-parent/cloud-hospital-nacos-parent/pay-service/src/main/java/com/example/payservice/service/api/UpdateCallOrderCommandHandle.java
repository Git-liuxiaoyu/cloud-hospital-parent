package com.example.payservice.service.api;

import com.example.payservice.service.command.CallProofPay.updatecallorder.UpdateCallOrderCommand;
import com.example.payservice.util.ResponseResult;

/**
 * 修改订单状态
 */
public interface UpdateCallOrderCommandHandle {

   ResponseResult<Void> updateCallProof(UpdateCallOrderCommand updateCallOrderCommand);
}
