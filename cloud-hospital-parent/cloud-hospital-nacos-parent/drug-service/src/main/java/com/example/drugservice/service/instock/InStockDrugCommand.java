package com.example.drugservice.service.instock;

import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.xml.transform.Source;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class InStockDrugCommand {
    private String no;
    private String name;
    private Integer typeId;
    private Integer num;
    private BigDecimal costprice;
    private BigDecimal saleprice;
    private String location;
    private Date productiontime;
    private Date expirationtime;

    private IInStockDrugCommandHandle handle;

    public InStockDrugCommand(){
        this.handle= ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IInStockDrugCommandHandle.class);
    }

    public InStockDrugCommand(String name, Integer typeId, Integer num, BigDecimal costprice, BigDecimal saleprice, String location, Date productiontime, Date expirationtime) {
        this();
        this.name = name;
        this.typeId = typeId;
        this.num = num;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.location = location;
        this.productiontime = productiontime;
        this.expirationtime = expirationtime;
    }

    public void execute(){
        InStockDrugCommand drug = handle.getDrugByNameAndByLocation(this.name, this.location);

        if (drug==null){
            //添加药品
            handle.addDrug(this);
        }else {
            //修改库存 根据no
            this.no = drug.getNo();
            handle.updateDrug(this);
        }
    }
}
