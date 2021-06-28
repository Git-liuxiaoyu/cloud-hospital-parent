package com.example.drugservice.service.query;

import com.example.drugservice.adapt.DrugAdapt;
import com.example.drugservice.adapt.DrugOddAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQueryDrugOddCommandHandle implements IExampleQueryDrugOddCommandHandle{
    @Autowired
    private DrugOddAdapt adapt;

    @Override
    public List<DrugOddVo> findList(ExampleQueryDrugOddCommand command) {
        return adapt.findDrugListByExample(command);
    }

    @Override
    public DrugOddVo getByNo(String no) {
        return adapt.getByNo(no);
    }

    @Override
    public void updateById(Long drugOddId) {
        adapt.updateById(drugOddId);
    }
}
