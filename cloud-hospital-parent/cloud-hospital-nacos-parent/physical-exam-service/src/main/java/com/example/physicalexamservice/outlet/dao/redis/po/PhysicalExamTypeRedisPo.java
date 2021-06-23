package com.example.physicalexamservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * 实体类 - RedisPo - PhysicalExamType
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash
public class PhysicalExamTypeRedisPo {

    @Id
    private Integer id;

    private String name;

    private String description;

    @Indexed
    private String status;

}
