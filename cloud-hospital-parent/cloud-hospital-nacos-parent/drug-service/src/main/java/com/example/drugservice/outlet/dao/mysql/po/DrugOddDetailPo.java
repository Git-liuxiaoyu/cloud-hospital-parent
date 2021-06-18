package com.example.drugservice.outlet.dao.mysql.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugOddDetailPo {
    private Long id;

    private Long drugoddid;

    private Integer drugid;

    private Long drugnum;

    private DrugPo drugPo;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDrugoddid() {
        return drugoddid;
    }

    public void setDrugoddid(Long drugoddid) {
        this.drugoddid = drugoddid;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }

    public Long getDrugnum() {
        return drugnum;
    }

    public void setDrugnum(Long drugnum) {
        this.drugnum = drugnum;
    }
}