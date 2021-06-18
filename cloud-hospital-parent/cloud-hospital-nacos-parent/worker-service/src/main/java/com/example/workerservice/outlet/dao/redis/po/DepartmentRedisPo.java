package com.example.workerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 *
 * 实体类 - RedisPo - Department
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash
public class DepartmentRedisPo {

    @Id
    private Integer id;

    @Indexed
    private Integer divisionid;

    private String no;

    private String name;

    private Long directorid;

    private String location;

    private String phone;

    private String description;

    @Indexed
    private String status;

}
