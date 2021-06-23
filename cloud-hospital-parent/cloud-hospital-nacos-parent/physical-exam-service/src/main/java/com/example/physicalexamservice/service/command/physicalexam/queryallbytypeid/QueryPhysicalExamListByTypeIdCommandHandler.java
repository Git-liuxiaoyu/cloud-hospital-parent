package com.example.physicalexamservice.service.command.physicalexam.queryallbytypeid;

import com.example.physicalexamservice.adapter.PhysicalExamDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.service.api.physicalexam.IQueryPhysicalExamListByTypeIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 时间 - IQueryPhysicalExamListByTypeIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class QueryPhysicalExamListByTypeIdCommandHandler implements IQueryPhysicalExamListByTypeIdCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamDaoAdapter physicalExamDaoAdapter;

    public QueryPhysicalExamListByTypeIdCommandHandler(PhysicalExamDaoAdapter physicalExamDaoAdapter) {
        this.physicalExamDaoAdapter = physicalExamDaoAdapter;
    }

    /* 构造注入 - 结束 */
    @Override
    public List<PhysicalExamTreatVo> action(QueryPhysicalExamListByTypeIdCommand command) {
        return physicalExamDaoAdapter.queryListByTypeId(command.getTypeId(), PhysicalExamTreatVo.STATUS_NORMAL);
    }
}
