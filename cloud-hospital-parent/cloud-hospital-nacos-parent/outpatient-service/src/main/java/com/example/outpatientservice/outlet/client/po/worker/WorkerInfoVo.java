package com.example.outpatientservice.outlet.client.po.worker;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkerInfoVo {
    private Integer id;
    private String name;
    private String phone;
    public static final String STATUS_NORMAL = "1";
}
