package com.example.outpatientservice.service.add;

import com.example.outpatientservice.adapt.OutPatientAdapt;
import com.example.outpatientservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class AddOutPatientDrugRecordCommandHandle implements IAddOutPatientDrugRecordCommandHandle{
    @Autowired
    private OutPatientAdapt adapt;
    public ResponseResult<Long> openfenDrug(AddOutPatientDrugRecordCommand command){
        ResponseResult<Long> result = adapt.openfenDrug(command);
        log.info("serviece层的返回{}",result.getData());
        return result;
    }
}
