package com.example.physicalexamservice.service.command.physicalexamrecord.queryByNo;

import com.example.physicalexamservice.adapter.PhysicalExamRecordDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IQueryPhysicalExamRecordByNoCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IQueryPhysicalExamRecordByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Component
@Slf4j
public class QueryPhysicalExamRecordByNoCommandHandler implements IQueryPhysicalExamRecordByNoCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter;

    public QueryPhysicalExamRecordByNoCommandHandler(PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter) {
        this.physicalExamRecordDaoAdapter = physicalExamRecordDaoAdapter;
    }

    /* 构造注入 - 结束 */
    @Override
    public PhysicalExamRecordVo action(QueryPhysicalExamRecordByNoCommand command) {
        try {
            return physicalExamRecordDaoAdapter.queryByNo(command.getNo());
        } catch (NullPointerException e) {
            throw new PhysicalExamRecordNotFoundException();
        }
    }
}
