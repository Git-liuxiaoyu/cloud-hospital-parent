package com.example.drugservice.service.query;

import com.example.drugservice.adapt.InventoryOddAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQueryInventoryOddCommandHandle implements IExampleQueryInventoryOddCommandHandle{
    @Autowired
    private InventoryOddAdapt adapt;
    @Override
    public List<InventoryOddVo> findList(ExampleQueryInventoryOddCommand command) {
        return adapt.findDrugListByExample(command);
    }
}

