package com.example.payservice.service.api;

import com.example.payservice.service.command.CallProofPay.updatecallorder.UpdateCallOrderCommand;
import com.example.payservice.service.command.pharmacyPay.updatepharmacypay.UpdatePharmacyOrderCommand;
import com.example.payservice.util.ResponseResult;

public interface UpdatePharmacyOrderCommandHandle {


    ResponseResult<Void> updatePharmacyProof(UpdatePharmacyOrderCommand updatePharmacyOrderCommand);

    ResponseResult<Void>updateDrugStatus(UpdatePharmacyOrderCommand updatePharmacyOrderCommand);
}
