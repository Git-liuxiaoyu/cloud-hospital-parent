package com.example.outpatientservice.service.add;

import com.example.outpatientservice.outlet.client.DrugServiceClient;
import com.example.outpatientservice.outlet.publisher.api.IUpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.service.update.IUpdateOutPatientCommandHandle;
import com.example.outpatientservice.service.update.IUpdateOutPatientRecordCommandHandle;
import com.example.outpatientservice.util.ApplicationContextHolder;
import com.example.outpatientservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Slf4j
public class AddOutPatientDrugRecordCommand {
    private Long outPatientId;
    private Long outPatientRecordId;
    private Long doctorid;
    private Integer departmentId;
    private Long registerid;

    private Integer drugTypeId;
    private Long drugId;
    private Integer drugNum;
    private BigDecimal drugPrice;

    private List<AddOutPatientDrugRecordCommand> detailCommands;
    //修改功能的接口
    private IUpdateOutPatientCommandHandle updateHandle;

    private IAddOutPatientDrugRecordCommandHandle handle;

    private IUpdateOutPatientRecordCommandHandle recordHandle;

    public AddOutPatientDrugRecordCommand(){
        this.recordHandle=ApplicationContextHolder
                            .getApplicationContext()
                            .getBean(IUpdateOutPatientRecordCommandHandle.class);
        this.updateHandle= ApplicationContextHolder
                .getApplicationContext()
                .getBean(IUpdateOutPatientCommandHandle.class);
        this.handle=ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddOutPatientDrugRecordCommandHandle.class);
    }

    public AddOutPatientDrugRecordCommand(Long outPatientId, Long outPatientRecordId, Long doctorid, Integer departmentId,Long registerid, Integer drugTypeId, Long drugId, Integer drugNum, BigDecimal drugPrice, List<AddOutPatientDrugRecordCommand> detailCommands) {
        this();
        this.outPatientId = outPatientId;
        this.outPatientRecordId = outPatientRecordId;
        this.doctorid = doctorid;
        this.departmentId = departmentId;
        this.registerid=registerid;
        this.drugTypeId = drugTypeId;
        this.drugId = drugId;
        this.drugNum = drugNum;
        this.drugPrice = drugPrice;
        this.detailCommands = detailCommands;
    }
    public void execute(){
        //修改患者状态为就诊完  9表示就诊结束
        updateHandle.UpdateById(this.outPatientId,"9");

        //修改后发个消息 带id
        IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent event
                =new IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent(this.registerid,"9");
        ApplicationContextHolder.getApplicationContext().publishEvent(event);

        //使用openfen把医生开的药添加到药品表单里
        ResponseResult<Long> result = handle.openfenDrug(this);
        //医生开药单的Id
        Long drugOddId = result.getData();

        //拿到药品表单回显id 添加到患者记录表里
        log.info("要修改就诊记录的id{}",this.outPatientRecordId);
        //修改药品记录
        recordHandle.updateById(drugOddId,this.outPatientRecordId,"1");
    }






}
