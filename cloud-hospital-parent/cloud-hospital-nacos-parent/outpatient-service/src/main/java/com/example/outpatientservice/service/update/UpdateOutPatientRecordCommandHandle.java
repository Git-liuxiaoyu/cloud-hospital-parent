package com.example.outpatientservice.service.update;

import com.example.outpatientservice.adapt.OutPatientAdapt;
import com.example.outpatientservice.adapt.OutPatientRecordAdapt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOutPatientRecordCommandHandle implements IUpdateOutPatientRecordCommandHandle{

    @Autowired
    private OutPatientRecordAdapt adapt;
    @Override
    public void updateById(Long OddId,Long outPatientRecordId,String updateType) {
        adapt.updateById(OddId,outPatientRecordId,updateType);
    }
}
