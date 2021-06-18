package com.example.takenumberservice.outlet.client.register.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {

    private Integer id;
    private String no;//挂号编码
    private Integer patientId;//病人id
    private Integer departmentId;//科室id
    private Integer roomId;//房间id
    private char type;//挂号类型
    private String regTime;//挂号时间（病人挂号的时间）
    private Integer rotaId;//选择排班的医生排班Id
    private String visitTime;//挂号的就诊时间
    private char visitSection;//就诊时间段（1、上午，2、下午）
    private BigDecimal price;//挂号费
    private char status;//挂号状态（0、未付款；1、以退款；2、付款失败；3、待初诊）
}
