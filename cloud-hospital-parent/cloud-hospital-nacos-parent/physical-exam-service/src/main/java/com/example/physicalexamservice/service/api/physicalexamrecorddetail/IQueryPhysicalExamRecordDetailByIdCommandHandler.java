package com.example.physicalexamservice.service.api.physicalexamrecorddetail;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.command.physicalexamreocrddetail.querybyid.QueryPhysicalExamRecordDetailByIdCommand;

/**
 * 接口 - IQueryPhysicalExamRecordByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
public interface IQueryPhysicalExamRecordDetailByIdCommandHandler {

    PhysicalExamRecordDetailVo action(QueryPhysicalExamRecordDetailByIdCommand command);

}
