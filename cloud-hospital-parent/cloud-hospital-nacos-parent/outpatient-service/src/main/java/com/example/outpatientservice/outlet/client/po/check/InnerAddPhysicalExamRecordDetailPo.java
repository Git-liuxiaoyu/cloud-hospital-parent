package com.example.outpatientservice.outlet.client.po.check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InnerAddPhysicalExamRecordDetailPo {
    private Long id;

    private Integer typeid;

    private Integer examid;

    private Integer count;

    private BigDecimal price;
}
