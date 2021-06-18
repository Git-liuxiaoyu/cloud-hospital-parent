package com.example.drugservice.service.update;

import com.example.drugservice.adapt.DrugOddAdapt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDrugOddCommandHandle implements IUpdateDrugOddCommandHandle{
    @Autowired
    private DrugOddAdapt adapt;
    @Override
    public void UpdateById(UpdateDrugOddCommand command) {
        adapt.updateDrugById(command);
    }
}
