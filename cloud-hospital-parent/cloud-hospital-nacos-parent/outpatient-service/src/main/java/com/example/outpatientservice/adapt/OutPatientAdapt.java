package com.example.outpatientservice.adapt;

import com.example.outpatientservice.adapt.converter.OutPatientVoConverter;
import com.example.outpatientservice.adapt.exception.AdapterException;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

@Service
public class OutPatientAdapt {
    @Autowired
    private OutPatientDao outPatientDao;
    @Autowired
    private OutPatientVoConverter converter;

    //查询 集合
    public List<OutPatientVo> findByExample(ExampleQueryOutPatientCommand command){
        OutPatientPo po = new OutPatientPo();
        List<OutPatientPo>poList= outPatientDao.selectByCon(po);
       //poList 转voList
        List<OutPatientVo> voList = converter.convert(poList);
        return voList;

    }

    //根据id查对象
    public OutPatientVo getById(Long id)  {
        try {
            OutPatientPo po = outPatientDao.selectByPrimaryKey(id);
            OutPatientVo vo = converter.convert(po);
            return vo;
        }catch (AdapterException e){
            e.printStackTrace();
            new AdapterException("根据id查询失败");
            return null;
        }

    }



    //修改门诊患者状态
    public void UpdateById(Long id){
        try{
            OutPatientPo po = new OutPatientPo();
            po.setId(id);
            po.setStatus("2");
            outPatientDao.updateByPrimaryKeySelective(po);
        }catch (AdapterException e){
            new AdapterException("修改门诊患者状态失败");
            e.printStackTrace();
        }

    }

}
