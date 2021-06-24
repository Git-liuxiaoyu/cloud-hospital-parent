package com.example.physicalexamservice.service.api.physicalexamrecord;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.service.command.physicalexamrecord.querydetaillistbyno.QueryPhysicalExamRecordDetailListByRecordNoCommand;

import java.util.List;

/**
 * 接口  - IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/23
 */
public interface IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler {

    List<PhysicalExamRecordDetailVo> action(QueryPhysicalExamRecordDetailListByRecordNoCommand command);

}
