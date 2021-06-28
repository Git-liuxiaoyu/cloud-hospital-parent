package com.example.payservice.service.command.CallProofPay.refundcallproof;


import com.example.payservice.service.api.RefundCallProofCommandHandle;
import com.example.payservice.util.ApplicationContextHolder;
import com.example.payservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class RefundCallProofCommand {

    private Long regId;//挂号id

    private String status;//订单状态

    private RefundCallProofCommandHandle handle;

    public RefundCallProofCommand(){
        handle = ApplicationContextHolder.getApplicationContext().getBean(RefundCallProofCommandHandle.class);
    }

    public RefundCallProofCommand(Long regId, String status) {
        this();
        this.regId = regId;
        this.status = status;
    }


    public ResponseResult<Void> execute(){
       return handle.CallProofrefund(this);
    }
}
