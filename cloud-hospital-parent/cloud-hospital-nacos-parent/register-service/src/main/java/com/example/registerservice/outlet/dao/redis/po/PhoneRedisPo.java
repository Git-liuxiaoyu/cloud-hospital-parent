package com.example.registerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/15:04
 * @Description: 存手机号的PO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class PhoneRedisPo {

    @Id
    private String phone;
}
