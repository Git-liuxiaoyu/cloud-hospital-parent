package com.example.outpatientservice.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Builder {

    //过号 绑定
//    @Bean
//    public Binding itemQueueExchange(
//            @Qualifier("outpatient_losenumber_exchange") Exchange exchange,
//            @Qualifier("outpatient_losenumber_queue") Queue queue) {
//        return BindingBuilder.bind(queue).to(exchange).with("outpatient.update").noargs();
//    }

    //就诊完 绑定

    @Bean
    public Binding outPatientOverQueueExchange(
            @Qualifier("outpatient_over_exchange") Exchange exchange,
            @Qualifier("outpatient_over_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("outpatient.update").noargs();
    }

}
