package com.example.registerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:51
 * @Description: 挂号的RegisterRedisPo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class RegisterRedisPo {
    @Id
    private Long id;
    private String no;
    private Long patientid;
    private String regtype;
    private Date regtime;
    private Long rotaid;
    private Integer departmentid;
    private Integer roomid;
    private Date visittime;
    private String visitsection;
    private BigDecimal price;
    private String type;
    private String status;
    private String phone;
}
