package com.example.drugservice.service.add;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Slf4j
@ToString
@NoArgsConstructor
public class AddDrugOddDetailCommand {
    private Integer drugTypeId;
    private Long drugId;
    private Integer drugNum;
    private BigDecimal drugPrice;
}
