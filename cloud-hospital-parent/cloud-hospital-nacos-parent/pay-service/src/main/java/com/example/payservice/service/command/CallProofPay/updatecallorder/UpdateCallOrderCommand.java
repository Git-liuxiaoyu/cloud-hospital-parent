package com.example.payservice.service.command.CallProofPay.updatecallorder;



import com.example.payservice.service.api.UpdateCallOrderCommandHandle;
import com.example.payservice.util.ApplicationContextHolder;
import com.example.payservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class UpdateCallOrderCommand {

    private String orderNum;//订单编号

    private String status;//订单状态（1：已付款、2未付款、3：已退款、4订单超时）

    private Long regId;

    private UpdateCallOrderCommandHandle handle;


    public UpdateCallOrderCommand(){
        handle = ApplicationContextHolder.getApplicationContext().getBean(UpdateCallOrderCommandHandle.class);
    }

    public UpdateCallOrderCommand(String orderNum, String status,Long regId) {
        this();
        this.regId = regId;
        this.orderNum = orderNum;
        this.status = status;
    }

    public ResponseResult<Void> execute(){

        return handle.updateCallProof(this);
    }
}
