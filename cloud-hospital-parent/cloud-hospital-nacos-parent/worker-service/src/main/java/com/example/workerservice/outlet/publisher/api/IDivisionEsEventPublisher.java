package com.example.workerservice.outlet.publisher.api;

import com.example.workerservice.service.command.division.add.AddDivisionCommand;
import com.example.workerservice.service.command.division.update.UpdateDivisionCommand;
import org.springframework.context.ApplicationEvent;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
public interface IDivisionEsEventPublisher {

    void insert(AddDivisionEsEvent event);

    void update(UpdateDivisionEsEvent event);

    /**
     * 内部类 - 添加DivisionEsEvent
     *
     */
    class AddDivisionEsEvent extends ApplicationEvent {
        public AddDivisionEsEvent(AddDivisionCommand command) {
            super(command);
        }
    }

    /**
     * 内部类 - 修改DivisionEsEvent
     *
     */
    class UpdateDivisionEsEvent extends ApplicationEvent {
        public UpdateDivisionEsEvent(UpdateDivisionCommand command) {
            super(command);
        }
    }


}
