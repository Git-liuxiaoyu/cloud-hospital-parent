package com.example.drugservice.outlet.dao.redis.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Date;
@RedisHash
@Data
public class DrugOddRedisPo {
    @Id
    private Long id;

    @Indexed
    private String no;

    private Date createtime;

    private Integer doctorid;

    private BigDecimal totalmoney;

    private Integer patientid;

    private String status;
}
