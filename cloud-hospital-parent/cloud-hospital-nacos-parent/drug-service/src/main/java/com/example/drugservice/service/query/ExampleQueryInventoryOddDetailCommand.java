package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Data
@AllArgsConstructor
@Slf4j
public class ExampleQueryInventoryOddDetailCommand {
    //根据盘点表单id查询详情
    private Long inventoryOddId;


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

