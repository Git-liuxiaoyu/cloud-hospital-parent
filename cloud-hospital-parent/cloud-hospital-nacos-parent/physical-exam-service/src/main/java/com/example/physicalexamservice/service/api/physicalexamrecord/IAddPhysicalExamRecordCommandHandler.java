package com.example.physicalexamservice.service.api.physicalexamrecord;

import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;

/**
 * 接口 - IAddPhysicalExamRecordCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IAddPhysicalExamRecordCommandHandler {

    String action(AddPhysicalExamRecordCommand command);

    /**
     * 自定义业务异常 - 没有找到对应体检项目
     **/
    class NotFoundPhysicalExamException extends RuntimeException {
        public NotFoundPhysicalExamException() {
            super("没有找到对应体检项目");
        }
    }

    /**
     * 自定义业务异常 - 体检项目剩余检测次数不足
     **/
    class PhysicalExamStockIsNotEnoughException extends RuntimeException {
        public PhysicalExamStockIsNotEnoughException() {
            super("体检项目剩余检测次数不足");
        }
    }

}
