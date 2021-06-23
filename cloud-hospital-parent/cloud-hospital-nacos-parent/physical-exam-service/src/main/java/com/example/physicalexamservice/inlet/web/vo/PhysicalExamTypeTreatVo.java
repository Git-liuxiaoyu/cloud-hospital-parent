package com.example.physicalexamservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Vo - For Treat - PhysicalExamType
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhysicalExamTypeTreatVo {

    private Integer id;

    private String name;

    private String status;

    public static final String STATUS_NORMAL = "1";

}
