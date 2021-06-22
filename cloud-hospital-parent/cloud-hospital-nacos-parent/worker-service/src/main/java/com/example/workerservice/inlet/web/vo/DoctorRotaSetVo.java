package com.example.workerservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Vo - DoctorRota - Set(设置时反显用)
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorRotaSetVo {

    private Long id;

    private Integer roomid;

    private Integer doctorid;

    private Integer maxpatient;

    private String status;

    public static final String STATUS_NORMAL = "1";

    public static final String STATUS_CANCEL = "0";

}
