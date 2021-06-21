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
public class UpdateDrugInstockOddCommand {
    private Long id;


    private IUpdateDrugInstockOddCommandHandle handle;

    public UpdateDrugInstockOddCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IUpdateDrugInstockOddCommandHandle.class);
    }
    public UpdateDrugInstockOddCommand(Long id){
        this();
        this.id=id;
    }

    public void execute(){
        handle.UpdateById(this);
    }
}
