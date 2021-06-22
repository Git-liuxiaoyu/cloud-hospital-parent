package com.example.workerservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.convert.DataSizeUnit;

import java.util.Date;

/**
 * 实体类 - Vo - DoctorRota
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorRotaVo {

    private Long id;

    private Integer departmentid;

    private String departmentname;

    private Date date;

    private String shifttype;

    private Integer doctorid;

    private String doctorName;

    private String doctorAvatar;

    /* 大于0就是专家号 */
    private String doctorLevel;

    private Integer leftpatient;

    private Integer maxpatient;

    private String status;

    public static final String STATUS_NORMAL="1";
}
