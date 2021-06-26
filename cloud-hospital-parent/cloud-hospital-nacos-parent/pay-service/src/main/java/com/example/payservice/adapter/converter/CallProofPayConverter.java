package com.example.payservice.adapter.converter;


import com.example.payservice.outlet.dao.mysql.callproofdao.pojo.CallProofPayPo;
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
        po.setRegId(addCallOrderCommand.getRegId());
        po.setTime(addCallOrderCommand.getTime());
        po.setId(addCallOrderCommand.getId());
        po.setNo(addCallOrderCommand.getNo());
        po.setOrderNum(addCallOrderCommand.getOrderNum());
        po.setMoney(addCallOrderCommand.getMoney());
        po.setPatientId(addCallOrderCommand.getPatientId());
        po.setType(addCallOrderCommand.getType());
        po.setStatus(addCallOrderCommand.getStatus());
        System.out.println("转换前："+addCallOrderCommand.getNo());
        System.out.println("转换："+po.getNo());

        return po;
    }


}
