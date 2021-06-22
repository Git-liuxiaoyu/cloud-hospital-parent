package com.example.physicalexamservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 实体类 - Vo - 就诊用 - PhysicalExam
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhysicalExamTreatVo {

    private Integer id;

    private String no;

    private String name;

    private BigDecimal price;

    private Long leftstock;

    private String status;

    public static final String STATUS_NORMAL = "1";

}
