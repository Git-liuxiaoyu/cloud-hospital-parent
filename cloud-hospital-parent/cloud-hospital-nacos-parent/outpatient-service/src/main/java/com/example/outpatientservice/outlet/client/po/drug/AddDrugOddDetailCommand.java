package com.example.outpatientservice.outlet.client.po.drug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddDrugOddDetailCommand {
    private Integer drugTypeId;
    private Long drugId;
    private Integer drugNum;
    private BigDecimal drugPrice;
}
