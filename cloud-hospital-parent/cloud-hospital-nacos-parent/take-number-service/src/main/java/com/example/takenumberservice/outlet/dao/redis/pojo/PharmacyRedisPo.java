package com.example.takenumberservice.outlet.dao.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class PharmacyRedisPo {

    /**
     * 存入药房redis的no
     */
    @Id
    private String no;
}
