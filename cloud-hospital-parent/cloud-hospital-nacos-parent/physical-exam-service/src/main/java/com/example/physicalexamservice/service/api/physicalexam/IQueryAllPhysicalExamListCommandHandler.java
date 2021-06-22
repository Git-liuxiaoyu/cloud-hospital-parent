package com.example.physicalexamservice.service.api.physicalexam;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.service.command.physicalexam.queryall.QueryAllPhysicalExamListCommand;

import java.util.List;

/**
 * 接口 - IQueryAllPhysicalExamListCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IQueryAllPhysicalExamListCommandHandler {

    List<PhysicalExamTreatVo> action(QueryAllPhysicalExamListCommand command);

}
