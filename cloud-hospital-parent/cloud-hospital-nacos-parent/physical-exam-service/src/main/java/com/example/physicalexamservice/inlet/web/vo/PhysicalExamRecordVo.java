package com.example.physicalexamservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalExamRecordVo {

    private Long id;

    private String no;

    /* 没有支付 */
    public static final String STATUS_NOTPAY = "9";

    public static final String STATUS_PAYED = "8";

}
