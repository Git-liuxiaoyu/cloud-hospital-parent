package com.example.outpatientservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutPatientVo {
    private Long id;
    private Long outPatientRecordId;
    private String patientno;
    private String patientname;
    private String gender;
    private String idcard;
    private String patientage;
    private Long registerid;
    private Long patientid;
    private Long departmentid;
    private Long doctorid;
    private Long rotaid;
    private String status;
    private Long queueno;
    private String medicard;
}
