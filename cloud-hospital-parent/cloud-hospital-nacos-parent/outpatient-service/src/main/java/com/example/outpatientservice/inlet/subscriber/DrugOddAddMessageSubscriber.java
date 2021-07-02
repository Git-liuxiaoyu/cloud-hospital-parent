package com.example.outpatientservice.inlet.subscriber;

import com.example.outpatientservice.outlet.client.PatientInfoServiceClient;
import com.example.outpatientservice.outlet.client.po.patient.Patient;
import com.example.outpatientservice.outlet.dao.mysql.OutPatientDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import com.example.outpatientservice.util.ResponseResult;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RabbitListener(queues = "patient_sort")
public class DrugOddAddMessageSubscriber {
    @Autowired
    private PatientInfoServiceClient client;
    @Autowired
    private OutPatientDao outPatientDao;

    @RabbitHandler
    public void handle(String patientInfo
                        ,Channel channel
                        , @Header(AmqpHeaders.DELIVERY_TAG)long tag)  {

        log.info("Receiver : {}", patientInfo);
        String sort =patientInfo.split(",")[0];
        log.info(sort);
        String patientid =patientInfo.split(",")[1];
        String registerid =patientInfo.split(",")[2];
        String doctorid =patientInfo.split(",")[3];
        String doctorname =patientInfo.split(",")[4];
        log.info(patientid);
        log.info(registerid);
        log.info(doctorid);
        log.info(doctorname);

        ResponseResult<Patient> patients = client.getByIdVoResponseResult(Long.parseLong(patientid));
        OutPatientPo po = new OutPatientPo();
        po.setStatus("0");
        po.setDoctorid(Long.parseLong(doctorid));
        po.setGender(patients.getData().getGender());
        po.setIdcard(patients.getData().getIdentityid());
        po.setMedicard(patients.getData().getMedicard());
        po.setPatientage(patients.getData().getAge().toString());
        po.setQueueno(Long.parseLong(sort));
        po.setPatientname(patients.getData().getName());
        po.setPatientno(patients.getData().getNo());
        po.setPatientid(patients.getData().getId());
        po.setRegisterid(Long.parseLong(registerid));
        outPatientDao.insert(po);

        try {
            channel.basicAck(tag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
