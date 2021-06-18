package com.example.drugservice.service.instock;

import com.example.drugservice.adapt.DrugAdapt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class InStockDrugCommandHandle implements IInStockDrugCommandHandle{
    @Autowired
    private DrugAdapt adapt;

    @Override
    public void addDrug(InStockDrugCommand command) {
        adapt.AddDrug(command);
    }

    @Override
    public void updateDrug(InStockDrugCommand command) {
        adapt.upDateDrug(command);
    }

    @Override
    public InStockDrugCommand getDrugByNameAndByLocation(String name, String location) {
        return adapt.getDrugByNameAndLocation(name,location);
    }
}
