package com.example.drugservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugInstockOddVo {
    private Long id;
    private String no;
    private String instockperson;
    private Date createtime;
    private String status;
}
