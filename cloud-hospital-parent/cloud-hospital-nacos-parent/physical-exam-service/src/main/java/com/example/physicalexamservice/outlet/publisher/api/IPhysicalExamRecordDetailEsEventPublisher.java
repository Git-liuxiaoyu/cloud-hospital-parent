package com.example.physicalexamservice.outlet.publisher.api;

import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import org.springframework.context.ApplicationEvent;

/**
 * 接口 - IPhysicalExamRecordDetailEsEventPublisher
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IPhysicalExamRecordDetailEsEventPublisher {

    /**
     * 添加 Es 方法
     *
     * @param event
     */
    void insert(AddPhysicalExamRecordDetailEsEvent event);

    /**
     * 内部类 - EsEvent - AddTeacher
     */
    class AddPhysicalExamRecordDetailEsEvent extends ApplicationEvent {
        public AddPhysicalExamRecordDetailEsEvent(AddPhysicalExamRecordCommand command) {
            super(command);
        }
    }

}
