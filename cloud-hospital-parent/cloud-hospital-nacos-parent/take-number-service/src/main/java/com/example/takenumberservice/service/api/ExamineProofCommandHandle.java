package com.example.takenumberservice.service.api;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommand;

/**
 * 检查科取票
 */
public interface ExamineProofCommandHandle {
    public ResponseResult<ExamineProofCommand> add(ExamineProofCommand addexamine);

}
