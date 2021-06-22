package com.example.workerservice.outlet.dao.mysql.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorRotaPo {
    private Long id;

    private Integer departmentid;

    private Date date;

    private String rotatype;

    private String shifttype;

    private Integer doctorid;

    private WorkerInfoPo workerInfoPo;

    private DepartmentPo departmentPo;

    private Integer leftpatient;

    private Integer maxpatient;

    private Integer roomid;

    private Integer createid;

    private Date createtime;

    private String status;
    
}