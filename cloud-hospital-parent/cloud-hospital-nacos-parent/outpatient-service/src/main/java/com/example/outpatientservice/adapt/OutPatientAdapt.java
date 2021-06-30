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

    //查询 集合
    public List<OutPatientVo> findByExample(ExampleQueryOutPatientCommand command){
        OutPatientPo po = new OutPatientPo();
        List<OutPatientPo>poList= outPatientDao.selectByCon(po);
       //poList 转voList
        List<OutPatientVo> voList = converter.convert(poList);
        for (OutPatientVo outPatientVo : voList) {
            //获取医生姓名
            ResponseResult<WorkerInfoVo> workers = workerClient.getWorkerInfoById(outPatientVo.getDoctorid().intValue());
            outPatientVo.setDoctorname(workers.getData().getName());
        }
        return voList;

    }

    //根据id查对象
    public OutPatientVo getById(Long id)  {
        try {
            //新增患者就诊记录 回显id 存入vo 传到前段
            OutPatientRecordPo recordPo = new OutPatientRecordPo();
            recordPo.setCreatetime(new Date());
            recordPo.setOutpatientid(id);
           outPatientRecordDao.insert(recordPo);
           Long outPatientRecordId=recordPo.getId();
            OutPatientPo po = outPatientDao.selectByPrimaryKey(id);
            OutPatientVo vo = converter.convert(po);
            vo.setOutPatientRecordId(outPatientRecordId);
            //获取医生姓名
            ResponseResult<WorkerInfoVo> workers = workerClient.getWorkerInfoById(vo.getDoctorid().intValue());
            vo.setDoctorname(workers.getData().getName());



            return vo;
        }catch (AdapterException e){
            e.printStackTrace();
            new AdapterException("根据id查询失败");
            return null;
        }

    }



    //修改门诊患者状态
    public void UpdateById(Long id,String status){
        try{
                //是检查就诊记录的话 表示为待复诊
                OutPatientPo po = new OutPatientPo();
                po.setId(id);
                po.setStatus(status);
                outPatientDao.updateByPrimaryKeySelective(po);

        }catch (AdapterException e){
            new AdapterException("修改门诊患者状态失败");
            e.printStackTrace();

        }
    }

    //发送openfen请求 把检查参数发到体检微服务 返回一个检查单id
    public ResponseResult<Long> openfenCheck(AddOutPatientRecordCommand command){
        AddPhysicalExamRecordCommand command1 = new AddPhysicalExamRecordCommand();
        command1.setDoctorid(command.getDoctorid().intValue());
        command1.setTreatrecordid(command.getOutPatientRecordId());
        command1.setPatientid(command.getOutPatientId());
        //转换
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
        log.info("openfen返回的参数{}",result.getData());
        return result;

    }


    //发送openfen请求 把药品参数发到药房微服务 返回一个药品单id
    public ResponseResult<Long> openfenDrug(AddOutPatientDrugRecordCommand command){
        AddDrugOddCommand command1 = new AddDrugOddCommand();
        command1.setPatientid(command.getOutPatientId().intValue());
        command1.setDoctorid(command.getDoctorid().intValue());
        BeanUtils.copyProperties(command,command1);

        log.info("{}",command1);
        ResponseResult<Long> result = client.addDrugOdd(command1);

        System.out.println(result);
        log.info("openfen返回的参数{}",result.getData());
        return result;

    }

}
