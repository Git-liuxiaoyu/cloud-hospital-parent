package com.example.drugservice.service.query;

import com.example.drugservice.adapt.InventoryOddDetailAdapt;
import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExampleQueryInventoryOddDetailCommandHandle implements IExampleQueryInventoryOddDetailCommandHandle{

    @Autowired
    private InventoryOddDetailAdapt adapt;

    @Override
    public List<InventoryOddDetailVo> findList(ExampleQueryInventoryOddDetailCommand command) {
        return adapt.findByInventoryOddId(command.getInventoryOddId());
    }
}

