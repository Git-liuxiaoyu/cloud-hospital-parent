package com.example.drugservice.outlet.dao.redis.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Date;

@RedisHash
@Data
public class DrugRedisPo {
    @Id
    private Long id;
    @Indexed
    private String no;
    @Indexed
    private String name;

    private BigDecimal costprice;

    private Integer stock;
    @Indexed
    private Integer typeid;
    @Indexed
    private String drugtype;

    private BigDecimal saleprice;

    private String location;

    private Date productiontime;

    private Date expirationtime;

    private String expirationdate;

    private String status;
}
