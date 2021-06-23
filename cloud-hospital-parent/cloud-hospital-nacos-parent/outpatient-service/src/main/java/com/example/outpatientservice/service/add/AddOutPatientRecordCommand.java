package com.example.outpatientservice.service.add;

import com.example.outpatientservice.outlet.publisher.UpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.outlet.publisher.api.IUpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.service.update.IUpdateOutPatientCommandHandle;
import com.example.outpatientservice.service.update.UpdateOutPatientCommand;
import com.example.outpatientservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class AddOutPatientRecordCommand {
    private Long outPatientId;
    private Long outPatientRecordId;
    private Long doctorid;
    private Long registerid;

    private Integer checkNum;
    private Integer checkProId;
    private Integer checkTypeId ;


    private List<AddOutPatientRecordCommand> purPeoList;

    //修改的方法
    private IUpdateOutPatientCommandHandle updateHandle;

    private IAddOutPatientRecordCommandHandle handle;

    public AddOutPatientRecordCommand(){
        this.updateHandle= ApplicationContextHolder
                            .getApplicationContext()
                            .getBean(IUpdateOutPatientCommandHandle.class);
        this.handle=ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IAddOutPatientRecordCommandHandle.class);

    }

    public AddOutPatientRecordCommand(Long outPatientId, Long outPatientRecordId, Integer checkNum, Integer checkProId, Integer checkTypeId, Long registerid) {
        this();
        this.outPatientId = outPatientId;
        this.outPatientRecordId = outPatientRecordId;
        this.checkNum = checkNum;
        this.checkProId = checkProId;
        this.checkTypeId = checkTypeId;
        this.registerid = registerid;
    }

    //患者状态改为就诊结束  调用updateCommand里的方法
    public void updateOutpatientStatusById(){
        //修改患者状态为就诊完
        updateHandle.UpdateById(this.outPatientId);

        //修改后发个消息 带id
        IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent event
                =new IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent(this.registerid,"2");
        ApplicationContextHolder.getApplicationContext().publishEvent(event);
    }
    //使用openfen把检查单添加到检查表单


    //拿到检查表单回显id 添加到患者记录表里

    //修改药品记录



}
