package com.example.drugservice.service.query;

import com.example.drugservice.adapt.DrugDetailAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleQueryDrugOddDetailCommandHandle implements IExampleQueryDrugOddDetailCommandHandle{
    @Autowired
    private DrugDetailAdapt adapt;

    @Override
    public List<DrugOddDetailVo> findListByDrugOddId(Long drugoddid) {
        return adapt.findByDrugOddId(drugoddid);
    }
}

