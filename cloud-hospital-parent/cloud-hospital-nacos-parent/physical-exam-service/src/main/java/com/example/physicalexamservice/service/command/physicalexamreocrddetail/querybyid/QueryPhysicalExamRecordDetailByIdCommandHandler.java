package com.example.physicalexamservice.service.command.physicalexamreocrddetail.querybyid;

import com.example.physicalexamservice.adapter.PhysicalExamRecordDetailDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.service.api.physicalexamrecorddetail.IQueryPhysicalExamRecordDetailByIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口是西安类 - 实现 - IQueryPhysicalExamRecordDetailByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Component
@Slf4j
public class QueryPhysicalExamRecordDetailByIdCommandHandler implements IQueryPhysicalExamRecordDetailByIdCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter;

    public QueryPhysicalExamRecordDetailByIdCommandHandler(PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter) {
        this.physicalExamRecordDetailDaoAdapter = physicalExamRecordDetailDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public PhysicalExamRecordDetailVo action(QueryPhysicalExamRecordDetailByIdCommand command) {
        /* 调用方法查询 */
        return physicalExamRecordDetailDaoAdapter.queryById(command.getId());
    }
}
