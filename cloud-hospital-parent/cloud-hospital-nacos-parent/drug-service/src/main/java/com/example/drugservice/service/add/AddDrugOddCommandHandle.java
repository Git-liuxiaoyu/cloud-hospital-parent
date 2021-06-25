package com.example.drugservice.service.add;

import com.example.drugservice.adapt.DrugOddAdapt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDrugOddCommandHandle implements IAddDrugOddCommandHandle{
    @Autowired
    private DrugOddAdapt adapt;

    @Override
    public Long AddDrugOdd(AddDrugOddCommand command) {
      return   adapt.addDrugOdd(command);
    }
}
