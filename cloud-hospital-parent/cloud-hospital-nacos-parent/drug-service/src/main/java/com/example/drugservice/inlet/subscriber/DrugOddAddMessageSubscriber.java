package com.example.drugservice.inlet.subscriber;

import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RabbitListener(queues = "real-queue")
public class DrugOddAddMessageSubscriber {

    @RabbitHandler
    public void handle(Long drugOddId
                        ,Channel channel
                        , @Header(AmqpHeaders.DELIVERY_TAG)long tag)  {

        log.info("Receiver : {}", drugOddId);

        /*通过药品单id查看状态是否为已付款  如果没付款 药单药品返回库存*/
        //Long departmentId = Long.parseLong(departmentIdString);
        // 无论是 inlet 层的 web controller、还是 timer、还是 subscriber 都是以统一的方式（命令模式）去调用 Service 层。
        try {
            ExampleQueryDrugOddCommand command = new ExampleQueryDrugOddCommand(drugOddId);
            command.updateById();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                channel.basicAck(tag,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
