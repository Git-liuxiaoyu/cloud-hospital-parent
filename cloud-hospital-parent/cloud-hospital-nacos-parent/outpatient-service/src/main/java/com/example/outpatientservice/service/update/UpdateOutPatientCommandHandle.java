package com.example.outpatientservice.service.update;

import com.example.outpatientservice.adapt.OutPatientAdapt;
import com.example.outpatientservice.service.add.AddOutPatientRecordCommand;
import com.example.outpatientservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOutPatientCommandHandle implements IUpdateOutPatientCommandHandle{

    @Autowired
    private  OutPatientAdapt adapt;
    @Override
    public void UpdateById(Long id,String status) {
        adapt.UpdateById(id,status);
    }

    public ResponseResult<Long> openfenCheck(AddOutPatientRecordCommand command){
      return  adapt.openfenCheck(command);
    }
}
