package com.example.takenumberservice.outlet.client.doctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Vo - OutRoom
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutRoomVo {

    private Long id;

    private Integer departmentid;

    private String roomname;

    private String status;

}
