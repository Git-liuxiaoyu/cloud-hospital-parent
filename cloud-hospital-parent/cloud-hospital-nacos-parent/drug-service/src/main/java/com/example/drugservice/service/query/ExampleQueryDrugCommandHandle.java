package com.example.drugservice.service.query;

import com.example.drugservice.adapt.DrugAdapt;
import com.example.drugservice.inlet.web.vo.DrugVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQueryDrugCommandHandle implements IExampleQueryDrugCommandHandle{
    @Autowired
    private DrugAdapt adapt;

    @Override
    public List<DrugVo> findList(ExampleQueryDrugCommand command) {
        return adapt.findDrugListByExample(command);
    }
}
