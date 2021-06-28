package com.example.drugservice.outlet.publisher.po;

import javafx.application.Application;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
public class AddDrugOddCommandEvent extends ApplicationEvent {
    private Long drugOddId;

    public AddDrugOddCommandEvent(Long drugOddId) {
        super(drugOddId);
        this.drugOddId=drugOddId;
    }

    public Long getDrugOddId(){
        return (Long) source;
    }



}
