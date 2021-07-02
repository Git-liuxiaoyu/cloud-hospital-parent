package com.example.physicalexamservice.service.api.physicalexamrecorddetail;

import com.example.physicalexamservice.service.command.physicalexamreocrddetail.update.UpdatePhysicalExamRecordDetailCommand;

/**
 * 接口 - IUpdatePhysicalRecordDetailCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
public interface IUpdatePhysicalExamRecordDetailCommandHandler {

    void action(UpdatePhysicalExamRecordDetailCommand command);

    /**
     * 自定义业务异常 - 体检项目剩余检测次数不足
     **/
    class NotFoundPhysicalExamRecordException extends RuntimeException {
        public NotFoundPhysicalExamRecordException() {
            super("没有找到对应的体检单");
        }
    }

    /**
     * 自定义业务异常 - 体检项目剩余检测次数不足
     **/
    class PhysicalExamRecordStateInvalidException extends RuntimeException {
        public PhysicalExamRecordStateInvalidException(String msg) {
            super(msg);
        }
    }

    /**
     * 自定义业务异常 - 体检项目剩余检测次数不足
     **/
    class NotFoundWorkerInfoException extends RuntimeException {
        public NotFoundWorkerInfoException() {
            super("没有找到体检的医生");
        }
    }


}
