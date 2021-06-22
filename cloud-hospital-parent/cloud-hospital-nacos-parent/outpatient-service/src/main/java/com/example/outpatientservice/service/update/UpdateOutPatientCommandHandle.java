package com.example.outpatientservice.service.update;

import com.example.outpatientservice.adapt.OutPatientAdapt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOutPatientCommandHandle implements IUpdateOutPatientCommandHandle{

    @Autowired
    private  OutPatientAdapt adapt;
    @Override
    public void UpdateById(Long id) {
        adapt.UpdateById(id);
    }
}
