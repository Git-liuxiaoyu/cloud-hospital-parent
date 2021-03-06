package com.example.registerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:51
 * @Description:患者的PatientRedisPo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class PatientRedisPo {
    @Id
    private Long id;
    private String no;
    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private String identityid;
    private String status;
    private Date createtime;
    private String medicard;
}
