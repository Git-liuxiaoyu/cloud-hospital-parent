package com.example.payservice.service.command.pharmacyPay.refundpharmacypay;

import com.example.payservice.adapter.PharmacyProofPayAdapter;
import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundPharmacyProofCommandHandle implements com.example.payservice.service.api.RefundPharmacyProofCommandHandle {

    @Autowired
    private PharmacyProofPayAdapter pharmacyProofPayAdapter;

    /**
     * 订单退款
     */
    @Override
    public ResponseResult<Void> PharmacyProofrefund(RefundPharmacyProofCommand refundPharmacyProofCommand) {
        ResponseResult<Void> voidResponseResult = pharmacyProofPayAdapter.RefundOharmacy(refundPharmacyProofCommand);

        return voidResponseResult;
    }

    /**
     * 修改药品单退款
     * @param refundPharmacyProofCommand
     * @return
     */
    @Override
    public ResponseResult<Void> PharmacyDrugFrefund(RefundPharmacyProofCommand refundPharmacyProofCommand) {
        ResponseResult<Void> refundoudg = pharmacyProofPayAdapter.Refundoudg(refundPharmacyProofCommand);
        return refundoudg;
    }
}
