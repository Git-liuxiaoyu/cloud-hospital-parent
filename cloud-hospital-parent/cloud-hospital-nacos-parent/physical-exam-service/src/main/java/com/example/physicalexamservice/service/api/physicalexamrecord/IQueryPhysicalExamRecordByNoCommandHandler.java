package com.example.physicalexamservice.service.api.physicalexamrecord;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.command.physicalexamrecord.queryById.QueryPhysicalExamRecordByIdCommand;
import com.example.physicalexamservice.service.command.physicalexamrecord.queryByNo.QueryPhysicalExamRecordByNoCommand;

/**
 * 接口 - IQueryPhysicalExamRecordCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
public interface IQueryPhysicalExamRecordByNoCommandHandler {

    PhysicalExamRecordVo action(QueryPhysicalExamRecordByNoCommand command);


    /**
     * 自定义业务异常 - 该体检单无法支付
     **/
    class PhysicalExamRecordNotFoundException extends RuntimeException {
        public PhysicalExamRecordNotFoundException() {
            super("该体检单没有查到");
        }
    }
}
