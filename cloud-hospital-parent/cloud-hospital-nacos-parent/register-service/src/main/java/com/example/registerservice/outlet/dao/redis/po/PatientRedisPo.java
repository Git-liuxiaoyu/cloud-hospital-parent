package com.example.registerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/15:04
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class PatientRedisPo {

    @Id
    private String phone;
}
