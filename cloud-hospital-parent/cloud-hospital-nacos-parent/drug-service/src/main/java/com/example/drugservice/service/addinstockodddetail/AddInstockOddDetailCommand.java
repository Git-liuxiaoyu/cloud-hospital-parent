package com.example.drugservice.service.addinstockodddetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInstockOddDetailCommand {
    private String name;
    private Integer num;
    private Integer typeId;
    private BigDecimal costprice;
    private BigDecimal saleprice;
    private String location;
    private Date productiontime;
    private Date expirationtime;
}
