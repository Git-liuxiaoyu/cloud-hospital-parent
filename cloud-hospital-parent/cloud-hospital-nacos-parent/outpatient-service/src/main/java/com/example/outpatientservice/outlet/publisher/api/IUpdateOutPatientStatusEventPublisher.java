package com.example.outpatientservice.outlet.publisher.api;

import com.rabbitmq.client.AMQP;
import lombok.Data;
import org.springframework.context.ApplicationEvent;


public interface IUpdateOutPatientStatusEventPublisher {

    public void publish(UpdatePatientCommandCompletedEvent event);


    public static class UpdatePatientCommandCompletedEvent extends ApplicationEvent {
        private String status;

        public UpdatePatientCommandCompletedEvent(Long registerid,String status) {
           super(registerid);
            this.status=status;
        }

        public String getStatus() {
            return status;
        }
    }
}
