package com.example.physicalexamservice.outlet.publisher.api;

import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import org.springframework.context.ApplicationEvent;

/**
 * 接口 - Publisher - EsEvent - PhysicalExamRecord
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IPhysicalExamRecordEsEventPublisher {

    /**
     * 添加 Es 方法
     *
     * @param event
     */
    void insert(AddPhysicalExamRecordEsEvent event);

    /**
     * 内部类 - EsEvent - AddTeacher
     */
    class AddPhysicalExamRecordEsEvent extends ApplicationEvent {
        public AddPhysicalExamRecordEsEvent(AddPhysicalExamRecordCommand command) {
            super(command);
        }
    }


}
