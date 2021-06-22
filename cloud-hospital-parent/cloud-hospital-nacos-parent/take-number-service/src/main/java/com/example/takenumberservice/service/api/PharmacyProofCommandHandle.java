package com.example.takenumberservice.service.api;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;

/**
 * 药房取票接口
 */
public interface PharmacyProofCommandHandle{


    public ResponseResult<PharmacyProofCommand> add(PharmacyProofCommand addProof);
}
