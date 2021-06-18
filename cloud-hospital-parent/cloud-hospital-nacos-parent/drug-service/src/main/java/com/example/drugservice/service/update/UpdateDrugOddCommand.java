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
public class UpdateDrugOddCommand {
    private Long id;


    private IUpdateDrugOddCommandHandle handle;

    public UpdateDrugOddCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IUpdateDrugOddCommandHandle.class);
    }
    public UpdateDrugOddCommand(Long id){
        this();
        this.id=id;
    }

    public void execute(){
        handle.UpdateById(this);
    }
}
