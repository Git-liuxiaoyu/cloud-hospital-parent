package com.example.outpatientservice.service.add;

import com.example.outpatientservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;


public interface IAddOutPatientDrugRecordCommandHandle {
    public ResponseResult<Long> openfenDrug(AddOutPatientDrugRecordCommand command);
}
