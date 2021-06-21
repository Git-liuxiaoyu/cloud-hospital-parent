package com.example.drugservice.service.update;

import com.example.drugservice.adapt.InventoryOddAdapt;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateInventoryOddCommandHandle implements IUpdateInventoryOddCommandHandle{
    @Autowired
    private InventoryOddAdapt adapt;
    @Override
    public void UpdateById(UpdateInventoryOddCommand command) {
        adapt.updateInventoryById(command);
    }
}
