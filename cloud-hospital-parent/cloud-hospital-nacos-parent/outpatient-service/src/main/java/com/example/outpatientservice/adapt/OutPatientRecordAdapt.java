package com.example.outpatientservice.adapt;

import com.example.outpatientservice.adapt.converter.OutPatientVoConverter;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientRecordDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientRecordPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OutPatientRecordAdapt {
    @Autowired
    private OutPatientVoConverter converter;
    @Autowired
    private OutPatientRecordDao outPatientRecordDao;




    public void updateById(Long OddId,Long outPatientRecordId,String updateType){
        if (updateType.equals("1")) {
            log.info("修改检查就诊记录");
            //修改
            OutPatientRecordPo po =  new OutPatientRecordPo();
            po.setIsdrug("y");
            po.setDrugoddid(OddId);
            po.setId(outPatientRecordId);
            outPatientRecordDao.updateByPrimaryKeySelective(po);
        }else if(updateType.equals("2")){
            log.info("修改开药就诊记录");
            //修改
            OutPatientRecordPo po =  new OutPatientRecordPo();
            po.setIscheck("y");
            po.setCheckoddid(OddId);
            po.setId(outPatientRecordId);
            outPatientRecordDao.updateByPrimaryKeySelective(po);
        }


    }


}
