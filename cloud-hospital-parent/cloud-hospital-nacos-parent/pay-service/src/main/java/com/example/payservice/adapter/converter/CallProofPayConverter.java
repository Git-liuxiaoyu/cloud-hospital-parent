package com.example.payservice.adapter.converter;


import com.example.payservice.outlet.dao.mysql.pojo.CallProofPayPo;
import com.example.payservice.service.command.addcallorder.AddCallOrderCommand;
import org.springframework.stereotype.Component;

@Component
public class CallProofPayConverter {

    /**
     * 挂号订单command转po
     * @param
     * @return
     */
    public CallProofPayPo excmtopo(AddCallOrderCommand addCallOrderCommand){
        CallProofPayPo po = new CallProofPayPo();
        po.setId(addCallOrderCommand.getId());
        po.setNo(addCallOrderCommand.getNo());
        po.setOrderNum(addCallOrderCommand.getOrderNum());
        po.setMoney(addCallOrderCommand.getMoney());
        po.setPatientId(addCallOrderCommand.getPatientId());
        po.setType(addCallOrderCommand.getType());
        po.setStatus(addCallOrderCommand.getStatus());

        return po;
    }


}
