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
public class ExamineProofRedisPo {

    @Id
    private String no;//第一次请求把no存入redis如果后面的请求请求和redis一样，则无操作返回

}
