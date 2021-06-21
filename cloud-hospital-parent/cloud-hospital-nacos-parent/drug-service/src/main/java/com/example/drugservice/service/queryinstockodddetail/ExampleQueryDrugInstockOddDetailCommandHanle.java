package com.example.drugservice.service.queryinstockodddetail;

import com.example.drugservice.adapt.DrugInstockOddDetailAdapt;
import com.example.drugservice.inlet.web.vo.DrugInstockOddDetailVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQueryDrugInstockOddDetailCommandHanle implements IExampleQueryDrugInstockOddDetailCommandHanle{
    @Autowired
    private DrugInstockOddDetailAdapt adapt;

    @Override
    public List<DrugInstockOddDetailVo> findByInstockId(Long instockOddId) {
        return adapt.findByInstockOddId(instockOddId);
    }
}
