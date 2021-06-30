package com.example.outpatientservice.service.addcases;

import com.example.outpatientservice.adapt.OutPatientCasesAdapt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AddOutPatientCasesCommandHandle implements IAddOutPatientCasesCommandHandle{
    @Autowired
    private OutPatientCasesAdapt adapt;

    public void addCases(AddOutPatientCasesCommand command){
        adapt.addCases(command);
    }


}
