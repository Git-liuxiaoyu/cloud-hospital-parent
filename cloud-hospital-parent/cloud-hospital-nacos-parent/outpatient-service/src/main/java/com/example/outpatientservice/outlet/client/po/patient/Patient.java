package com.example.outpatientservice.outlet.client.po.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Patient {

    private Long id;

    private String no;

    private String name;

    private Integer age;

    private String gender;

    private String phone;

    private String identityid;

    private String status;

    private Date createtime;

    private String medicard;
}
