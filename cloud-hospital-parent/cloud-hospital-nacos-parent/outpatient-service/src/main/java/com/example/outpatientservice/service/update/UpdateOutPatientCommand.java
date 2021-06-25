package com.example.outpatientservice.service.update;

import com.example.outpatientservice.outlet.publisher.api.IUpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class UpdateOutPatientCommand {
    private Long id;

    private String status;

    private Long registerid;

    private IUpdateOutPatientCommandHandle handle;

    public UpdateOutPatientCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IUpdateOutPatientCommandHandle.class);
    }
    public UpdateOutPatientCommand(Long id,Long registerid){
        this();
        this.id=id;
        this.registerid=registerid;
    }

    public void execute(){
        handle.UpdateById(this.id,"3");

        //根据门诊患者id查询出挂号id
        //执行发消息
        //过号状态为3
        IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent event
                = new IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent(this.registerid,"3");
        ApplicationContextHolder.getApplicationContext().publishEvent(event);
    }
}
