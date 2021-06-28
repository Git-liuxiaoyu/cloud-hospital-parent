package com.example.drugservice.outlet.publisher.api;

import com.example.drugservice.outlet.publisher.po.AddDrugOddCommandEvent;
import org.springframework.context.ApplicationEvent;

public interface IAddDrugOddEventPublisher {
    /**
     * 发布【药品表单被新建了】信息
     */
    public void publish(AddDrugOddCommandEvent event);



}
