package com.example.drugservice.service.outstock;

import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class OutStockDrugCommand {
    private String no;
    private Integer num;
    @ApiModelProperty(hidden = true)
    private IOutStockDrugCommandHandle handle;

    public OutStockDrugCommand(){
        this.handle = ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IOutStockDrugCommandHandle.class);
    }
    public OutStockDrugCommand(String no,Integer num){
        this();
        this.no =no;
        this.num=num;
    }

    public void execute(){
        handle.UpDateDrugByNo(this.no,this.num);
    }
}
