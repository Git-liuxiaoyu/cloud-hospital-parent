package com.example.outpatientservice.outlet.publisher;

import com.example.outpatientservice.outlet.publisher.api.IUpdateOutPatientStatusEventPublisher;
import com.example.outpatientservice.service.update.UpdateOutPatientCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/19:55
 * @Description:
 */
@Slf4j
@Component
public class UpdateOutPatientStatusEventPublisher implements IUpdateOutPatientStatusEventPublisher {
    @Autowired
    private RabbitTemplate template;

    @Override
    @EventListener(UpdatePatientCommandCompletedEvent.class)
    public void publish(UpdatePatientCommandCompletedEvent event) {
        //等于3 表示 过号 等于2表示就诊结束
        String status = event.getStatus();
        log.info("status状态为:{}",status);
        boolean equals = status.equals(2);
        boolean equals1 = status.equals("2");
        log.info("{}",equals);
        log.info("{}",equals1);


        if (status.equals("3")){
            log.debug("向outpatient_update_queue路由发送了过号挂号id为:{}！", event.getSource());
            //过号走这里
            template.convertAndSend("outpatient_over_exchange", "outpatient.update", event.getSource()+","+status);

        }else if(status.equals("2")) {
            log.debug("向outpatient_update_queue路由发送了就诊结束挂号id为:{}！", event.getSource());
            //就诊完走这里
            template.convertAndSend("outpatient_over_exchange", "outpatient.update", event.getSource()+","+status);
        }else  if(status.equals("9")){
            template.convertAndSend("outpatient_over_exchange", "outpatient.update", event.getSource()+","+status);
        } else {
            log.info("发消息失败");
        }
    }
}
