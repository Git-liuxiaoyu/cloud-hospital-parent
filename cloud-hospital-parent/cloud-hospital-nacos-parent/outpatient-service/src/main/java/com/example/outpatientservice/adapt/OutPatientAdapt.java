package com.example.outpatientservice.adapt;

import com.example.outpatientservice.adapt.converter.OutPatientVoConverter;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutPatientAdapt {
    @Autowired
    private OutPatientDao outPatientDao;
    @Autowired
    private OutPatientVoConverter converter;

    public List<OutPatientVo> findByExample(ExampleQueryOutPatientCommand command){
        OutPatientPo po = new OutPatientPo();
        List<OutPatientPo>poList= outPatientDao.selectByCon(po);
       //poList 转voList
        List<OutPatientVo> voList = converter.convert(poList);
        return voList;

    }
}
