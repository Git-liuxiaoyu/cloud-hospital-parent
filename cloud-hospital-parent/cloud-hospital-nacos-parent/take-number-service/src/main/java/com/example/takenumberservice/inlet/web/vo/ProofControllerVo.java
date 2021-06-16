package com.example.takenumberservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProofControllerVo {
    private Integer id;//id
    private Integer regId;//挂号id
    private Integer departmentId;//可是id
    private String roomName;//房间名
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private char status;//取票状态

}
