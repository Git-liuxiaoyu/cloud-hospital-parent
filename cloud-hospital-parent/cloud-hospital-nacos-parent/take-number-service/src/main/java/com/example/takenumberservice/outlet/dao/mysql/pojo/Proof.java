package com.example.takenumberservice.outlet.dao.mysql.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库实体类pojo
 */
@Data
@TableName("h_call_proof")
@AllArgsConstructor
@NoArgsConstructor
public class Proof {
    private Integer id;//id
    private Integer regId;//挂号id
    private Integer departmentId;//可是id
    private String roomName;//房间名
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private char status;//取票状态



}
