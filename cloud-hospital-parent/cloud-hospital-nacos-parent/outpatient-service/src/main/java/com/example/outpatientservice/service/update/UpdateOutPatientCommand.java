package com.example.outpatientservice.service.update;

import com.example.outpatientservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class UpdateOutPatientCommand {
    private Long id;

    private IUpdateOutPatientCommandHandle handle;

    public UpdateOutPatientCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IUpdateOutPatientCommandHandle.class);
    }
    public UpdateOutPatientCommand(Long id){
        this();
        this.id=id;
    }

    public void execute(){
        handle.UpdateById(this.id);
    }
}
