package com.example.outpatientservice.service.update;

import com.example.outpatientservice.service.add.AddOutPatientRecordCommand;
import com.example.outpatientservice.util.ResponseResult;

public interface IUpdateOutPatientCommandHandle {
    public void UpdateById(Long id,String status);

    public ResponseResult<Long> openfenCheck(AddOutPatientRecordCommand command);
}
