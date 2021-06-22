package com.example.workerservice.outlet.dao.redis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * 实体类 - RedisPo - OutRoom
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@RedisHash
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutRoomRedisPo {

    @Id
    private Long id;

    @Indexed
    private Integer departmentid;

    private String roomname;

    @Indexed
    private String status;


}
