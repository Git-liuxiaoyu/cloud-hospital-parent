package com.example.drugservice.outlet.dao.mysql.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugInstockoddDetailPo {
    private Long id;
    private String drugno;
    private Integer drugnum;
    private String drugname;
    private Integer drugtypeid;
    private BigDecimal drugcostprice;
    private BigDecimal drugsaleprice;
    private String druglocation;
    private Date drugproductiontime;
    private Date drugexpirationtime;
    private Long instockoddid;

    private DrugTypePo drugType;
}