package com.example.outpatientservice.service.addcases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


public interface IAddOutPatientCasesCommandHandle {
    public void addCases(AddOutPatientCasesCommand command);


}
