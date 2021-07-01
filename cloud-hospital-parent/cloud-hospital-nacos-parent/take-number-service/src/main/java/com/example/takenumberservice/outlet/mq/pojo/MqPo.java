package com.example.takenumberservice.outlet.mq.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqPo {


    private Integer orderNum;//排队序号
    private Long regId;//挂号id
    private Integer doctorId;//医生id
    private String doctorName;//医生姓名
    private Long patientId;//患者Id
}
