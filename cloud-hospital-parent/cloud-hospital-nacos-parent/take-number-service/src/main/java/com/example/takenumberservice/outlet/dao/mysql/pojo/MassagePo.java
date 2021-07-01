package com.example.takenumberservice.outlet.dao.mysql.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.misc.Version;

/**
 * 消息表实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MassagePo {
//    @TableId(type = IdType.AUTO)
    private Long id;//id
    private String exchange;//交换机
    private String routing_key;//路由key
    private String message_content;//消息内容
    private String status;//状态
    private Integer retry_count;//重试次数
    private Long version;//乐观锁版本
}
