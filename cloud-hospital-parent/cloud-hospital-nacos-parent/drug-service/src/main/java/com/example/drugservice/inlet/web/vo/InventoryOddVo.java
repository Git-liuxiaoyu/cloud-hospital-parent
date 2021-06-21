package com.example.drugservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOddVo {

    private Long id;

    private String no;

    private Date createtime;

    private String inventoryperson;

    private String status;



}
