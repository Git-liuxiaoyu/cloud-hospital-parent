package com.example.drugservice.service.addinventory;

import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
public class AddInventoryCommand {

   private String name;

    private List<AddInventoryDetailCommand> purPeoList;

    private IAddInventoryCommandHandle handle;

    public AddInventoryCommand (){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IAddInventoryCommandHandle.class);
    }

    public AddInventoryCommand(String name,List<AddInventoryDetailCommand> purPeoList){
        this();
        this.name=name;
        this.purPeoList=purPeoList;
    }

    public void execute(){
        handle.addInventory(this);
    }


}
