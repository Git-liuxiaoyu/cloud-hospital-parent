package com.example.physicalexamservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - RedisPo - PhysicalExamRecordDetail
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Data
@RedisHash
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhysicalExamRecordDetailRedisPo {

    @Id
    private Long id;

    @Indexed
    private Long recordid;

    @Indexed
    private Integer typeid;

    private String typeName;

    private Integer examid;

    private String examName;

    private Integer count;

    private BigDecimal price;

    private Date examtime;

    private String resultfile;

    private String resulttext;

    @Indexed
    private Integer examdocid;

    private String examDocName;

    private String status;

}
