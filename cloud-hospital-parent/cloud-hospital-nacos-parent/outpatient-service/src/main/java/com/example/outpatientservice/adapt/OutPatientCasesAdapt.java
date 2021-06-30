package com.example.outpatientservice.adapt;

import com.example.outpatientservice.outlet.dao.mysql.OutPatientCasesDao;
import com.example.outpatientservice.service.addcases.AddOutPatientCasesCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OutPatientCasesAdapt {
    @Autowired
    private OutPatientCasesDao outPatientCasesDao;

    public void addCases(AddOutPatientCasesCommand command){

    }
}
