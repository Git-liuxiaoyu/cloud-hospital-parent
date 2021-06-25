package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@Slf4j
@ApiModel
public class ExampleQueryInventoryOddDetailCommand {
    //根据盘点表单id查询详情
    private Long inventoryOddId;

    @ApiModelProperty(hidden = true)
    private IExampleQueryInventoryOddDetailCommandHandle handle;

    public ExampleQueryInventoryOddDetailCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IExampleQueryInventoryOddDetailCommandHandle.class);
    }

    public ExampleQueryInventoryOddDetailCommand(Long inventoryOddId){
        this();
        this.inventoryOddId = inventoryOddId;
    }

    public List<InventoryOddDetailVo> execute(){

      return   handle.findList(this);
    }



    
}

