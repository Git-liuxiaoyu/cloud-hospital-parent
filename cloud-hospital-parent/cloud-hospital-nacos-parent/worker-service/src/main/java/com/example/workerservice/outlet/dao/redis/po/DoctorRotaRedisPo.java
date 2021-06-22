package com.example.workerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Date;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash
public class DoctorRotaRedisPo {

    @Id
    private Long id;

    @Indexed
    private Integer departmentid;

    @Indexed
    private Date date;

    private String rotatype;

    private String shifttype;

    private Integer doctorid;

    private String doctorName;

    private String doctorAvatar;

    private String doctorLevel;

    private Integer leftpatient;

    private Integer maxpatient;

    private Integer roomid;

    @Indexed
    private String status;
}
