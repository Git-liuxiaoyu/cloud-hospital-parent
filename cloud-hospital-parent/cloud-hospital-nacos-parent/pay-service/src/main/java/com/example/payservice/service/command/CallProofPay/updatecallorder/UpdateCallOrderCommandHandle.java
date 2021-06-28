package com.example.payservice.service.command.CallProofPay.updatecallorder;

import com.example.payservice.adapter.CallProofPayAdapter;
import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateCallOrderCommandHandle implements com.example.payservice.service.api.UpdateCallOrderCommandHandle {


    @Autowired
    private CallProofPayAdapter callProofPayAdapter;
    /**
     * 修改订单状态
     * @param updateCallOrderCommand
     * @return
     */
    @Override
    public ResponseResult<Void> updateCallProof(UpdateCallOrderCommand updateCallOrderCommand) {
        RefundCallProofCommand updateregstatus = new RefundCallProofCommand();
        updateregstatus.setRegId(updateCallOrderCommand.getRegId());
        updateregstatus.setStatus("1");
        //调用适配器修改挂号状态
        callProofPayAdapter.updateRegStatus(updateregstatus);
        //调用适配器修改订单状态
        return callProofPayAdapter.updateCallProofStatus(updateCallOrderCommand);

    }
}
