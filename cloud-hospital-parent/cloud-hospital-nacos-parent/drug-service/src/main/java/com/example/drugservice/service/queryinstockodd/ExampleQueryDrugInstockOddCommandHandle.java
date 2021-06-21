package com.example.drugservice.service.queryinstockodd;

import com.example.drugservice.adapt.DrugInstockOddAdapt;
import com.example.drugservice.inlet.web.vo.DrugInstockOddVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQueryDrugInstockOddCommandHandle implements IExampleQueryDrugInstockOddCommandHandle{
    @Autowired
    private DrugInstockOddAdapt adapt;

    @Override
    public List<DrugInstockOddVo> findByExample(ExampleQueryDrugInstockOddCommand command) {
        return adapt.findByExample(command);
    }
}
