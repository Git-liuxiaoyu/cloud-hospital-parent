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
public class WorkerInfoPo {
    private Integer id;

    private String no;

    private String name;

    private Date birthday;

    private String gender;

    private String identityno;

    private String topeducation;

    private String career;

    private Integer departmentid;

    private DepartmentPo departmentPo;

    private Integer positionid;

    private PositionPo positionPo;

    private Date signtime;

    private Date resigntime;

    private String avatar;

    private String status;

    private String phone;

    private String param2;

    private Long param3;

    private Date param4;


}