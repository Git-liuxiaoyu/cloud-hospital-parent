package com.example.payservice.service.command.pharmacyPay.addpharmacypay;

import com.example.payservice.service.command.CallProofPay.addcallorder.AddCallOrderCommand;
import com.example.payservice.util.ResponseResult;

public class AddPharmacyOrderCommandHandle implements com.example.payservice.service.api.AddPharmacyOrderCommandHandle {

    /**
     * 添加进数据库
     * @param addCallOrderCommand
     * @return
     */
    @Override
    public ResponseResult<AddPharmacyOrderCommand> execute(AddPharmacyOrderCommand addCallOrderCommand) {
//        //根据no查询信息
//        ResponseResult<AddCallOrderCommand> findbyno = callProofPayAdapter.findbyno(addCallOrderCommand.getRegId());
//        if(findbyno.getCode() !=200){
//            return new ResponseResult<AddCallOrderCommand>(400,"未成功",null);
//        }
//        //患者id
//        addCallOrderCommand.setPatientId(findbyno.getData().getPatientId());
//        addCallOrderCommand.setNo(findbyno.getData().getNo());
//        log.info("service:{}",addCallOrderCommand.toString());
//        //添加订单为未支付
//        int i = callProofPayAdapter.addCallProof(addCallOrderCommand);
//
//        if(i>0){
//            return new ResponseResult<AddCallOrderCommand>(200,"添加成功",null);
//        }else{
//            return new ResponseResult<AddCallOrderCommand>(400,"添加失败",null);
//        }
//
//    }

        return null;
    }
}
