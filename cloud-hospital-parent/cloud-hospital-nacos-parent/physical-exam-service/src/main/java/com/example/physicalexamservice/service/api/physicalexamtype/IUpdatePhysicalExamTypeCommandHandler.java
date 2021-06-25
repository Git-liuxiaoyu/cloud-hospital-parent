package com.example.physicalexamservice.service.api.physicalexamtype;

import com.example.physicalexamservice.service.command.physicalexamtype.update.UpdatePhysicalExamTypeCommand;

/**
 * 接口 - IUpdatePhysicalExamTypeCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
public interface IUpdatePhysicalExamTypeCommandHandler {

    void action(UpdatePhysicalExamTypeCommand command);

}
