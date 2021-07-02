package com.example.drugservice.service.update;

import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@ToString
@Slf4j
public class UpdateInventoryOddCommand {
    private Long id;

    @ApiModelProperty(hidden = true)
    private IUpdateInventoryOddCommandHandle handle;

    public UpdateInventoryOddCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IUpdateInventoryOddCommandHandle.class);
    }
    public UpdateInventoryOddCommand(Long id){
        this();
        this.id=id;
    }

    public void execute(){
        handle.UpdateById(this);
    }
}
