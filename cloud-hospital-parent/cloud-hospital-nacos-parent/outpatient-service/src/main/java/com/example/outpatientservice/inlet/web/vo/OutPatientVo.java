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
    private Long registerid;
    private Long patientid;
    private Long doctorid;
    private String status;
    private Long orderno;
    private Date endtime;
}
