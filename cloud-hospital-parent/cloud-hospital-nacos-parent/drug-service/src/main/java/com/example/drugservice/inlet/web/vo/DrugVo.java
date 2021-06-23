package com.example.drugservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DrugVo {

    private Long id;

    private String no;

    private String name;

    private BigDecimal costprice;

    private Integer stock;

    private Integer typeid;

    private String typeName;

    private BigDecimal saleprice;

    private String location;

    private Date productiontime;

    private Date expirationtime;

    private String expirationdate;

    private String status;
}
