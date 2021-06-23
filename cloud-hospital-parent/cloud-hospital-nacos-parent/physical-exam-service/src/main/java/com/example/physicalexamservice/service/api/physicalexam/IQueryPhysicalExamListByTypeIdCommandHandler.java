package com.example.physicalexamservice.service.api.physicalexam;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.service.command.physicalexam.queryallbytypeid.QueryPhysicalExamListByTypeIdCommand;

import java.util.List;

/**
 * 接口 - IQueryPhysicalExamListByTypeIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IQueryPhysicalExamListByTypeIdCommandHandler {

    List<PhysicalExamTreatVo> action(QueryPhysicalExamListByTypeIdCommand command);

}
