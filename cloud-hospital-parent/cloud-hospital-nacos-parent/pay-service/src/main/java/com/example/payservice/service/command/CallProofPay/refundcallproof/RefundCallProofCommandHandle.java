package com.example.payservice.service.command.CallProofPay.refundcallproof;

import com.example.payservice.adapter.CallProofPayAdapter;
import com.example.payservice.outlet.dao.mysql.pojo.CallProofPayPo;
import com.example.payservice.service.command.CallProofPay.updatecallorder.UpdateCallOrderCommand;
import com.example.payservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RefundCallProofCommandHandle implements com.example.payservice.service.api.RefundCallProofCommandHandle {


    @Autowired
    private CallProofPayAdapter callProofPayAdapter;

    /**
     * 退款操作
     * @param refundCallProofCommand
     * @return
     */
    @Override
    public ResponseResult<Void> CallProofrefund(RefundCallProofCommand refundCallProofCommand) {
        //查询数据库有没有该订单
        CallProofPayPo findregId = callProofPayAdapter.findRegId(refundCallProofCommand.getRegId());
        if(findregId == null){
            return new ResponseResult<>(500,"未查询到该订单",null);
        }
        if(findregId.getStatus().equals("3")){
            return new ResponseResult<>(500,"该订单已退款，请勿重复操作！",null);
        }
        //修改订单状态为已退款
        UpdateCallOrderCommand update = new UpdateCallOrderCommand();
        update.setOrderNum(findregId.getOrderNum());
        update.setStatus("3");
        update.setRegId(refundCallProofCommand.getRegId());
        ResponseResult<Void> execute = update.execute();
        if(execute.getCode() !=200){
            return execute;
        }

        return new ResponseResult<>(200,"退款成功",null);
    }
}
