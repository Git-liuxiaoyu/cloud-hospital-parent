package com.example.drugservice.outlet.dao.mysql.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOddDetailPo {
    private Long id;

    private String drugno;

    private Integer drugnum;

    private String reason;

    private DrugPo drugPo;

    private Long inventoryOddId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugno() {
        return drugno;
    }

    public void setDrugno(String drugno) {
        this.drugno = drugno == null ? null : drugno.trim();
    }

    public Integer getDrugnum() {
        return drugnum;
    }

    public void setDrugnum(Integer drugnum) {
        this.drugnum = drugnum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}