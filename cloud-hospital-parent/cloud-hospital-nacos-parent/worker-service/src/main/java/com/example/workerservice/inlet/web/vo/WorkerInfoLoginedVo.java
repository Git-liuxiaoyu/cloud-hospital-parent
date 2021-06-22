package com.example.workerservice.inlet.web.vo;

import lombok.*;

/**
 * 登陆后传送给页面的 WorkerInfo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkerInfoLoginedVo {

    private Integer id;

    private String no;

    private String name;

    private Integer departmentId;

    private String departmentName;

    private String positionType;

    private String positionLevel;

    private String positionIsOut;

    private String positionIsIn;

    private String positionIsMdc;

    private String positionStatus;

    private String avatar;

    private String status;

}
