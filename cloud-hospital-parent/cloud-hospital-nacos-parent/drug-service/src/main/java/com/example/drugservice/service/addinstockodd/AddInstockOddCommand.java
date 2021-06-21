package com.example.drugservice.service.addinstockodd;

import com.example.drugservice.service.addinstockodddetail.AddInstockOddDetailCommand;
import com.example.drugservice.service.addinventory.AddInventoryDetailCommand;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddInstockOddCommand {
    private String inStockPerson;

    private List<AddInstockOddDetailCommand> purPeoList;

    private IAddInstockOddCommandHandle handle;

    public AddInstockOddCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IAddInstockOddCommandHandle.class);
    }

    public AddInstockOddCommand(String inStockPerson, List<AddInstockOddDetailCommand>purPeoList ){
        this();
        this.inStockPerson=inStockPerson;
        this.purPeoList=purPeoList;
    }

    public void execute(){
        handle.AddInstockOddAndAddInstockOddDetail(this);
    }

}
