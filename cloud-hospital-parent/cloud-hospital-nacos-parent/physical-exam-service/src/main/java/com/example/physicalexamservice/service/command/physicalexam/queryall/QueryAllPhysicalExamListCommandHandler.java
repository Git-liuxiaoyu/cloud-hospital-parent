package com.example.physicalexamservice.service.command.physicalexam.queryall;

import com.example.physicalexamservice.adapter.PhysicalExamDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.service.api.physicalexam.IQueryAllPhysicalExamListCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 - IQueryAllPhysicalExamListCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class QueryAllPhysicalExamListCommandHandler implements IQueryAllPhysicalExamListCommandHandler {
    /* 构造注入 - 开始 */
    private final PhysicalExamDaoAdapter physicalExamDaoAdapter;

    public QueryAllPhysicalExamListCommandHandler(PhysicalExamDaoAdapter physicalExamDaoAdapter) {
        this.physicalExamDaoAdapter = physicalExamDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<PhysicalExamTreatVo> action(QueryAllPhysicalExamListCommand command) {
        return physicalExamDaoAdapter.queryAllForTreat(PhysicalExamTreatVo.STATUS_NORMAL);
    }
}
