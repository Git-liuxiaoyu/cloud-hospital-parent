package com.example.workerservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - DepartmentVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentVo {

    private Integer id;

    private Integer divisionid;

    private String name;

    private String status;

    public static final String STATUS_NORMAL = "1";

}
