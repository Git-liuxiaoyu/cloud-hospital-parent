package com.example.drugservice.service.addinstockodddetail;

import com.fasterxml.jackson.annotation.JsonFormat;
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
   // @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date productiontime;
   // @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date expirationtime;
}
