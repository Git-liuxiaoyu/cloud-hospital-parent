package com.example.payservice.service.command.addcallorder;

import com.example.payservice.adapter.CallProofPayAdapter;
import com.example.payservice.inlet.web.controller.vo.CallProofPayVo;
import com.example.payservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCallOrderCommandHandle implements com.example.payservice.service.api.AddCallOrderCommandHandle {


    @Autowired
    private CallProofPayAdapter callProofPayAdapter;
    /**
     * 添加挂号订单
     * @param addCallOrderCommand
     * @return
     */
    @Override
    public ResponseResult<AddCallOrderCommand> execute(AddCallOrderCommand addCallOrderCommand) {

        //根据no查询信息
        ResponseResult<AddCallOrderCommand> findbyno = callProofPayAdapter.findbyno(addCallOrderCommand.getNo());
        if(findbyno.getCode() !=200){
            return new ResponseResult<AddCallOrderCommand>(400,"未成功",null);
        }
        addCallOrderCommand.setType(findbyno.getData().getType());
        addCallOrderCommand.setPatientId(findbyno.getData().getPatientId());
        //addCallOrderCommand.set


        //添加订单为未支付
        int i = callProofPayAdapter.addCallProof(addCallOrderCommand);


        if(i>0){
            return new ResponseResult<AddCallOrderCommand>(200,"添加成功",null);
        }else{
            return new ResponseResult<AddCallOrderCommand>(400,"添加失败",null);
        }

    }
}
