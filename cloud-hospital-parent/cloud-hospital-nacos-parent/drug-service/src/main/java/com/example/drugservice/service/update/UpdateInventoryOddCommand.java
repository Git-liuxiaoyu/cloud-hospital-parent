package com.example.drugservice.service.update;

import com.example.drugservice.util.ApplicationContextHolder;
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
