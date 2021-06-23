package com.example.physicalexamservice.service.api.physicalexamtype;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.service.command.physicalexamtype.queryall.QueryAllPhysicalExamTypeListCommand;

import java.util.List;

/**
 * 接口 - IQueryAllPhysicalExamTypeListCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IQueryAllPhysicalExamTypeListCommandHandler {

    List<PhysicalExamTypeTreatVo> action(QueryAllPhysicalExamTypeListCommand command);

}
