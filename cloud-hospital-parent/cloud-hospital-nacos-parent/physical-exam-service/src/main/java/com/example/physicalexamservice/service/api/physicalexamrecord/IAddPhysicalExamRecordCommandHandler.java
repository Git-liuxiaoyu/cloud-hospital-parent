package com.example.physicalexamservice.service.api.physicalexamrecord;

import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;

/**
 * 接口 - IAddPhysicalExamRecordCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IAddPhysicalExamRecordCommandHandler {

    Long action(AddPhysicalExamRecordCommand command);

}
