package com.example.physicalexamservice.service.command.physicalexamtype.queryall;

import com.example.physicalexamservice.adapter.PhysicalExamTypeDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.service.api.physicalexamtype.IQueryAllPhysicalExamTypeListCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 -IQueryAllPhysicalExamTypeListCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class QueryAllPhysicalExamTypeListCommandHandler implements IQueryAllPhysicalExamTypeListCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter;

    public QueryAllPhysicalExamTypeListCommandHandler(PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter) {
        this.physicalExamTypeDaoAdapter = physicalExamTypeDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<PhysicalExamTypeTreatVo> action(QueryAllPhysicalExamTypeListCommand command) {
        /* 执行方法并返回 */
        return physicalExamTypeDaoAdapter.queryAll(PhysicalExamTreatVo.STATUS_NORMAL);
    }
}
