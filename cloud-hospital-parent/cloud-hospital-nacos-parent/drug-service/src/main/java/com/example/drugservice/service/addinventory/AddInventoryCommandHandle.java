package com.example.drugservice.service.addinventory;

import com.example.drugservice.adapt.InventoryOddAdapt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddInventoryCommandHandle implements IAddInventoryCommandHandle{
    @Autowired
    private InventoryOddAdapt adapt;
    @Override
    public void addInventory(AddInventoryCommand command) {
        adapt.addInventoryOdd(command);
    }
}
