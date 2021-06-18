package com.example.registerservice.service.query.querysubject;

import com.example.registerservice.adapter.converter.SubjectVoConverter;
import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.outlet.client.po.DivisionClientPo;
import com.example.registerservice.outlet.client.worker.IWorkerServiceClient;
import com.example.registerservice.service.api.IQuerySubjectCommandHandler;
import com.example.registerservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/10:40
 * @Description:
 */
@Component
public class QuerySubjectCommandHandler implements IQuerySubjectCommandHandler {

    @Autowired
    private IWorkerServiceClient client;

    @Autowired
    private SubjectVoConverter converter;

    @Override
    public List<SubjectVo> action() {
        ResponseResult<List<DivisionClientPo>> all = client.findAll();
        List<DivisionClientPo> data = all.getData();
        List<SubjectVo> convert = converter.convert(data);
        return convert;
    }


}
