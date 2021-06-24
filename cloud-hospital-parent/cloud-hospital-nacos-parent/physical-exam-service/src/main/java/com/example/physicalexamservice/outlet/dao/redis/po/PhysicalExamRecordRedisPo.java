package com.example.physicalexamservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 实体类 - RedisPo -
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash
public class PhysicalExamRecordRedisPo {

    @Id
    private Long id;

    @Indexed
    private String no;

    private Long treatrecordid;

    private Integer doctorid;

    private Long patientid;

    private Date createtime;

    private String status;

}
