package com.example.payservice.service.command.pharmacyPay.refundpharmacypay;

import com.example.payservice.service.api.RefundPharmacyProofCommandHandle;
import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.util.ApplicationContextHolder;
import com.example.payservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
public class RefundPharmacyProofCommand {

    private Long drugoddId;//药品单id

    private String status;//订单状态

    private RefundPharmacyProofCommandHandle handle;


    public RefundPharmacyProofCommand(){
        handle = ApplicationContextHolder
                .getApplicationContext()
                .getBean(RefundPharmacyProofCommandHandle.class);
    }

    public RefundPharmacyProofCommand(Long drugoddId, String status) {
        this();
        this.drugoddId = drugoddId;
        this.status = status;
    }


    //修改订单状态为已退款
    public ResponseResult<Void> execute(){
        return handle.PharmacyProofrefund(this);
    }

    /**
     * 修改药品单状态为已退款
     * @return
     */
    public ResponseResult<Void> updateDrug(){
        return handle.PharmacyDrugFrefund(this);
    }
}
