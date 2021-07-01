package com.example.takenumberservice.config;


import com.example.takenumberservice.outlet.dao.mysql.MassageDao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.MassagePo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@Slf4j
public class MqConfig {

    @Autowired
    private MassageDao massageDao;

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        // 设置开启 Mandatory，才能触发回调函数，无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);
        // 关键就是以下两句
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            // 这里的 correlationData 来源于 convertAndSend 方法。
            log.debug("消息唯一标识 ： {}", correlationData);
            if (ack) {
                log.debug("消息已发送至 RabbitMQ（的Exchange），修改 id 为 {} 的状态。", correlationData.getId());
                //修改状态
                MassagePo msgpo = new MassagePo();
                msgpo.setId(Long.parseLong(correlationData.getId()));
                msgpo.setStatus("1");
                int i = massageDao.updateMessage(msgpo);//修改状态
            } else {
                log.debug("消息未能发送到 Exchange。失败原因 {}", cause);
                MassagePo msg = new MassagePo();
                msg.setId(Long.parseLong(correlationData.getId()));
                //查询id对应消息的状态
                MassagePo massagePo = massageDao.findbyId(msg);
                if(massagePo.getStatus().equals("2")||massagePo.getStatus().equals("0")){
                    //修改状态为发送失败
                    MassagePo msgpo = new MassagePo();
                    msgpo.setId(Long.parseLong(correlationData.getId()));
                    msgpo.setStatus("2");
                    int i = massageDao.updateMessage(msgpo);//修改状态
                }

            }
        });

        return rabbitTemplate;
    }
}
