package com.example.payservice.service.api;

import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.service.command.pharmacyPay.refundpharmacypay.RefundPharmacyProofCommand;
import com.example.payservice.util.ResponseResult;

public interface RefundPharmacyProofCommandHandle {

    /**
     * 药房退款退款
     * @return
     */
    ResponseResult<Void> PharmacyProofrefund(RefundPharmacyProofCommand refundPharmacyProofCommand);

    ResponseResult<Void>PharmacyDrugFrefund(RefundPharmacyProofCommand refundPharmacyProofCommand);

}
