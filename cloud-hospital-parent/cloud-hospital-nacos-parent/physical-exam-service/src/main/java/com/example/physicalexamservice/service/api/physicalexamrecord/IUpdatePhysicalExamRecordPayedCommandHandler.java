package com.example.physicalexamservice.service.api.physicalexamrecord;

import com.example.physicalexamservice.service.command.physicalexamrecord.payed.UpdatePhysicalExamRecordPayedCommand;

/**
 * 接口 - IUpdatePhysicalExamRecordPayedCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
public interface IUpdatePhysicalExamRecordPayedCommandHandler {

    void action(UpdatePhysicalExamRecordPayedCommand command);

    /**
     * 自定义业务异常 - 找不到该体检记录
     **/
    class PhysicalExamRecordNotFoundException extends RuntimeException {
        public PhysicalExamRecordNotFoundException() {
            super("找不到该体检记录");
        }
    }

    /**
     * 自定义业务异常 - 该体检单无法支付
     **/
    class PhysicalExamRecordCannotPayException extends RuntimeException {
        public PhysicalExamRecordCannotPayException() {
            super("该体检单无法支付");
        }
    }
}
