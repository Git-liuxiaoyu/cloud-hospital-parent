package com.example.outpatientservice.adapt;

import com.example.outpatientservice.adapt.converter.OutPatientVoConverter;
import com.example.outpatientservice.adapt.exception.AdapterException;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.outlet.client.CheckServiceClient;
import com.example.outpatientservice.outlet.client.DrugServiceClient;
import com.example.outpatientservice.outlet.client.WorkerServiceClient;
import com.example.outpatientservice.outlet.client.po.check.AddPhysicalExamRecordCommand;
import com.example.outpatientservice.outlet.client.po.check.InnerAddPhysicalExamRecordDetailPo;
import com.example.outpatientservice.outlet.client.po.drug.AddDrugOddCommand;
import com.example.outpatientservice.outlet.client.po.worker.WorkerInfoVo;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientDao;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientRecordDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientRecordPo;
import com.example.outpatientservice.service.add.AddOutPatientDrugRecordCommand;
import com.example.outpatientservice.service.add.AddOutPatientRecordCommand;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import com.example.outpatientservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OutPatientAdapt {
    @Autowired
    private OutPatientDao outPatientDao;
    @Autowired
    private OutPatientVoConverter converter;
    @Autowired
    private OutPatientRecordDao outPatientRecordDao;

    @Autowired
    private DrugServiceClient client;
    @Autowired
    private CheckServiceClient checkClient;

    @Autowired
    private WorkerServiceClient workerClient;

    //?????? ??????
    public List<OutPatientVo> findByExample(ExampleQueryOutPatientCommand command){
        OutPatientPo po = new OutPatientPo();
        List<OutPatientPo>poList= outPatientDao.selectByCon(po);
       //poList ???voList
        List<OutPatientVo> voList = converter.convert(poList);
        for (OutPatientVo outPatientVo : voList) {
            //??????????????????
            ResponseResult<WorkerInfoVo> workers = workerClient.getWorkerInfoById(outPatientVo.getDoctorid().intValue());
            outPatientVo.setDoctorname(workers.getData().getName());
        }
        return voList;

    }

    //??????id?????????
    public OutPatientVo getById(Long id)  {
        try {
            //???????????????????????? ??????id ??????vo ????????????
            OutPatientRecordPo recordPo = new OutPatientRecordPo();
            recordPo.setCreatetime(new Date());
            recordPo.setOutpatientid(id);
           outPatientRecordDao.insert(recordPo);
           Long outPatientRecordId=recordPo.getId();
            OutPatientPo po = outPatientDao.selectByPrimaryKey(id);
            OutPatientVo vo = converter.convert(po);
            vo.setOutPatientRecordId(outPatientRecordId);
            //??????????????????
            ResponseResult<WorkerInfoVo> workers = workerClient.getWorkerInfoById(vo.getDoctorid().intValue());
            vo.setDoctorname(workers.getData().getName());



            return vo;
        }catch (AdapterException e){
            e.printStackTrace();
            new AdapterException("??????id????????????");
            return null;
        }

    }



    //????????????????????????
    public void UpdateById(Long id,String status){
        try{
                //??????????????????????????? ??????????????????
                OutPatientPo po = new OutPatientPo();
                po.setId(id);
                po.setStatus(status);
                outPatientDao.updateByPrimaryKeySelective(po);

        }catch (AdapterException e){
            new AdapterException("??????????????????????????????");
            e.printStackTrace();

        }
    }

    //??????openfen?????? ???????????????????????????????????? ?????????????????????id
    public ResponseResult<Long> openfenCheck(AddOutPatientRecordCommand command){
        AddPhysicalExamRecordCommand command1 = new AddPhysicalExamRecordCommand();
        command1.setDoctorid(command.getDoctorid().intValue());
        command1.setTreatrecordid(command.getOutPatientRecordId());
        command1.setPatientid(command.getOutPatientId());
        //??????
        List<InnerAddPhysicalExamRecordDetailPo> poList = new ArrayList<>();
        for (AddOutPatientRecordCommand recordCommand : command.getPurPeoList()) {
            InnerAddPhysicalExamRecordDetailPo po = new InnerAddPhysicalExamRecordDetailPo();
            po.setCount(recordCommand.getCheckNum());
            po.setExamid(recordCommand.getCheckProId());
            po.setTypeid(recordCommand.getCheckTypeId());
            poList.add(po);
        }
        command1.setInnerAddPhysicalExamRecordDetailPoList(poList);
        ResponseResult<Long> result = checkClient.addPhysicalExamRecord(command1);

        System.out.println(result);
        log.info("openfen???????????????{}",result.getData());
        return result;

    }


    //??????openfen?????? ???????????????????????????????????? ?????????????????????id
    @Transactional
    public ResponseResult<Long> openfenDrug(AddOutPatientDrugRecordCommand command){
        AddDrugOddCommand command1 = new AddDrugOddCommand();
        command1.setPatientid(command.getOutPatientId().intValue());
        command1.setDoctorid(command.getDoctorid().intValue());
        BeanUtils.copyProperties(command,command1);

        log.info("{}",command1);
        ResponseResult<Long> result = client.addDrugOdd(command1);

        System.out.println(result);
        log.info("openfen???????????????{}",result.getData());
        return result;

    }

}
