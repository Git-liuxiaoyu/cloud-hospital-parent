package com.example.outpatientservice.service.addcases;

import com.example.outpatientservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class AddOutPatientCasesCommand {
    private Long patientid;
    private Long outPatientRecordId;
    private Long doctorid;
    private Long departmentid;
    private String temperature;
    private String pulse;
    private String blood;
    private String result;
    private String advice;

    private Long drugoddid;
    private Long checkoddid;
    private Long hospitalid;

    @ApiModelProperty(hidden = true)
    private IAddOutPatientCasesCommandHandle handle;

    public AddOutPatientCasesCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IAddOutPatientCasesCommandHandle.class);
    }

    public AddOutPatientCasesCommand(Long patientid, Long outPatientRecordId, Long doctorid, Long departmentid, String temperature, String pulse, String blood, String result, String advice, Long drugoddid, Long checkoddid, Long hospitalid) {
        this();
        this.patientid = patientid;
        this.outPatientRecordId = outPatientRecordId;
        this.doctorid = doctorid;
        this.departmentid = departmentid;
        this.temperature = temperature;
        this.pulse = pulse;
        this.blood = blood;
        this.result = result;
        this.advice = advice;
        this.drugoddid = drugoddid;
        this.checkoddid = checkoddid;
        this.hospitalid = hospitalid;
    }

    public void execute(){
        handle.addCases(this);
    }
}
