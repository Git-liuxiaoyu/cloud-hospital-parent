package com.example.takenumberservice.outlet.client.doctor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorVo {
    private Integer doctorId;//医生id

    private String doctorName;//医生姓名

}
