package com.example.outpatientservice.adapt;

import com.example.outpatientservice.outlet.dao.mysql.OutPatientCasesDao;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientCasesPo;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import com.example.outpatientservice.service.addcases.AddOutPatientCasesCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OutPatientCasesAdapt {
    @Autowired
    private OutPatientCasesDao outPatientCasesDao;

    @Autowired
    private OutPatientDao dao;
    //添加病历表
    public void addCases(AddOutPatientCasesCommand command){
        OutPatientCasesPo po = new OutPatientCasesPo();
        po.setOutpatientid(command.getPatientid());
        BeanUtils.copyProperties(command,po);
        outPatientCasesDao.insert(po);

        //修改患者状态
        OutPatientPo po1 = new OutPatientPo();
        po1.setId(command.getPatientid());
        po1.setStatus("3");
        dao.updateByPrimaryKeySelective(po1);
    }

    //修改病历表
//    public void updateById()


    //根据患者id查询病历表
}
