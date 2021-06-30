package com.example.outpatientservice.service.add;

import com.example.outpatientservice.outlet.publisher.UpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.outlet.publisher.api.IUpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.service.update.IUpdateOutPatientCommandHandle;
import com.example.outpatientservice.service.update.IUpdateOutPatientRecordCommandHandle;
import com.example.outpatientservice.service.update.UpdateOutPatientCommand;
import com.example.outpatientservice.util.ApplicationContextHolder;
import com.example.outpatientservice.util.ResponseResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@ApiModel
public class AddOutPatientRecordCommand {
    @ApiModelProperty(value="门诊患者id")
    private Long outPatientId;
    @ApiModelProperty(value="门诊患者记录id")
    private Long outPatientRecordId;
    @ApiModelProperty(value="医生id")
    private Long doctorid;
    @ApiModelProperty(value="挂号id")
    private Long registerid;
    @ApiModelProperty(value="检查次数")
    private Integer checkNum;
    @ApiModelProperty(value="检查名id")
    private Integer checkProId;
    @ApiModelProperty(value="检查类型id")
    private Integer checkTypeId ;

    @ApiModelProperty(value="检查集合 装检查属性")
    private List<AddOutPatientRecordCommand> purPeoList;

    //修改的方法
    private IUpdateOutPatientCommandHandle updateHandle;

    private IAddOutPatientRecordCommandHandle handle;

    private IUpdateOutPatientRecordCommandHandle recordHandle;

    public AddOutPatientRecordCommand(){
        this.recordHandle= ApplicationContextHolder
                .getApplicationContext()
                .getBean(IUpdateOutPatientRecordCommandHandle.class);
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
    public Long updateOutpatientStatusById(){
        //修改患者状态为就诊完  2表示待复诊
        updateHandle.UpdateById(this.outPatientId,"2");

        //修改后发个消息 带id
        IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent event
                =new IUpdateOutPatientStatusEventPublisher.UpdatePatientCommandCompletedEvent(this.registerid,"2");
        ApplicationContextHolder.getApplicationContext().publishEvent(event);

        //使用openfen把检查单添加到检查表单
        ResponseResult<Long> result = updateHandle.openfenCheck(this);
        Long checkOddId = result.getData();


        //拿到检查表单回显id 添加到患者记录表里
        recordHandle.updateById(checkOddId,outPatientRecordId,"2");
        //修改药品记录

        return checkOddId;

    }




}
