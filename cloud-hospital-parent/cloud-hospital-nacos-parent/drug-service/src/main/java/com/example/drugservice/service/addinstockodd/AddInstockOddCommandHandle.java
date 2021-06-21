package com.example.drugservice.service.addinstockodd;

import com.example.drugservice.adapt.DrugInstockOddAdapt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddInstockOddCommandHandle implements IAddInstockOddCommandHandle{
    @Autowired
    private DrugInstockOddAdapt adapt;
    @Override
    public void AddInstockOddAndAddInstockOddDetail(AddInstockOddCommand command) {
            adapt.addInstockOddAndInstockDetail(command);
    }
}
