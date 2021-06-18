package com.example.registerservice.service.query.querysubjecttype;

import com.example.registerservice.adapter.converter.SubjectTypeVoConverter;
import com.example.registerservice.adapter.converter.SubjectVoConverter;
import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.outlet.client.po.DepartmentClientPo;
import com.example.registerservice.outlet.client.po.DivisionClientPo;
import com.example.registerservice.outlet.client.worker.IWorkerServiceClient;
import com.example.registerservice.service.api.IQuerySubjectCommandHandler;
import com.example.registerservice.service.api.IQuerySubjectTypeCommandHandler;
import com.example.registerservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/10:40
 * @Description:
 */
@Component
public class QuerySubjectTypeCommandHandler implements IQuerySubjectTypeCommandHandler {

    @Autowired
    private IWorkerServiceClient client;

    @Autowired
    private SubjectTypeVoConverter converter;

    @Override
    public List<SubjectTypeVo> action(QuerySubjectTypeCommand command) {
        ResponseResult<List<DepartmentClientPo>> departmentListByDivisionId = client.getDepartmentListByDivisionId(command.getId());
        List<DepartmentClientPo> data = departmentListByDivisionId.getData();
        List<SubjectTypeVo> convert = converter.convert(data);
        return convert;
    }
}
