package com.example.drugservice.service.outstock;

import com.example.drugservice.adapt.DrugAdapt;
import org.springframework.beans.factory.annotation.Autowired;

public class OutStockDrugCommandHandle implements IOutStockDrugCommandHandle{
    @Autowired
    private DrugAdapt adapt;

    @Override
    public void UpDateDrugByNo(String no, Integer num) {
    adapt.updateDrugReduce(no,num);
    }
}
