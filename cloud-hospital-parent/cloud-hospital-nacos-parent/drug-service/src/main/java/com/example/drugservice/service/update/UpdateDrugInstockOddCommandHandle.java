package com.example.drugservice.service.update;

import com.example.drugservice.adapt.DrugInstockOddAdapt;
import com.example.drugservice.adapt.InventoryOddAdapt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDrugInstockOddCommandHandle implements IUpdateDrugInstockOddCommandHandle{
    @Autowired
    private DrugInstockOddAdapt adapt;
    @Override
    public void UpdateById(UpdateDrugInstockOddCommand command) {
        adapt.updateDrugInstockOddById(command);
    }
}
