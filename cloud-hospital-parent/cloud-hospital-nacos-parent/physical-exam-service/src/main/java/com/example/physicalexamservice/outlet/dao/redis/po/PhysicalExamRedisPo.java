package com.example.physicalexamservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;

/**
 * 实体类 - RedisPo -  PhysicalExam
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash
public class PhysicalExamRedisPo {

    @Id
    private Integer id;

    private String no;

    private String name;

    private BigDecimal price;

    private Long leftstock;

    @Indexed
    private String status;

}
