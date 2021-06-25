package com.example.physicalexamservice.service.api.physicalexamtype;

import com.example.physicalexamservice.service.command.physicalexamtype.add.AddPhysicalExamTypeCommand;

/**
 * 接口 - IAddPhysicalExamTypeCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
public interface IAddPhysicalExamTypeCommandHandler {

    Integer action(AddPhysicalExamTypeCommand command);

    /**
     * 自定义业务异常 - 检查类型名称重复
     **/
    class PhysicalExamTypeNameRepeatedException extends RuntimeException {
        public PhysicalExamTypeNameRepeatedException() {
            super("检查类型名称重复,请更换名称");
        }
    }


}
