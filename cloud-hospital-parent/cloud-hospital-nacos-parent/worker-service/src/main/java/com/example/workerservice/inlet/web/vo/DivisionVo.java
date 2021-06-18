package com.example.workerservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Division
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DivisionVo {

    private Integer id;

    private String name;

    /* 状态 - 正常状态 */
    public static final String STATUS_NORMAL = "1";

}
