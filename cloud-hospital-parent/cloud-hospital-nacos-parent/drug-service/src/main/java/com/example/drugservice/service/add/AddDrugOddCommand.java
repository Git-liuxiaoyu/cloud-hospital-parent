package com.example.drugservice.service.add;

import com.example.drugservice.outlet.publisher.po.AddDrugOddCommandEvent;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class AddDrugOddCommand {
    @Autowired
    private RabbitTemplate template;

    private Long outPatientId;
    private Integer doctorid;
    private Integer patientid;
    private Long outPatientRecordId;

    private List<AddDrugOddDetailCommand> detailCommands;

    private IAddDrugOddCommandHandle handle;

    public AddDrugOddCommand(){
        this.handle = ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IAddDrugOddCommandHandle.class);
    }
    public AddDrugOddCommand(Long outPatientId,Integer doctorid,Integer patientid,List<AddDrugOddDetailCommand> detailCommands){
        this();
        this.patientid=patientid;
        this.doctorid=doctorid;
        this.patientid=patientid;
        this.detailCommands=detailCommands;
    }


    public Long execute(){
        //添加药品单  然后回显id  再添加药品详情
        //药品表单id   并且预减库存
       Long drugOddId=  handle.AddDrugOdd(this);

       //发消息到死信队列 延迟加载 30分钟后如果没有付款就 把库存加回来
        // 执行完业务，喊一嗓子：调用 publisher 发消息
        AddDrugOddCommandEvent event = new AddDrugOddCommandEvent(drugOddId);
        ApplicationContextHolder.getApplicationContext().publishEvent(event);


        return drugOddId;
    }


}
