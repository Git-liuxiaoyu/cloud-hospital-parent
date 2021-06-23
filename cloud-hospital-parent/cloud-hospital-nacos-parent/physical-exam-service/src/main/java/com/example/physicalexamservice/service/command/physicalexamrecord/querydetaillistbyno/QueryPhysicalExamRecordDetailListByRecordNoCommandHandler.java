package com.example.physicalexamservice.service.command.physicalexamrecord.querydetaillistbyno;

import com.example.physicalexamservice.adapter.PhysicalExamRecordDaoAdapter;
import com.example.physicalexamservice.adapter.PhysicalExamRecordDetailDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 接口 - 实现 - IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/23
 */
@Component
@Slf4j
public class QueryPhysicalExamRecordDetailListByRecordNoCommandHandler implements IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter;

    private final PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter;

    public QueryPhysicalExamRecordDetailListByRecordNoCommandHandler(PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter, PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter) {
        this.physicalExamRecordDetailDaoAdapter = physicalExamRecordDetailDaoAdapter;
        this.physicalExamRecordDaoAdapter = physicalExamRecordDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public PhysicalExamRecordDetailVo action(QueryPhysicalExamRecordDetailListByRecordNoCommand command) {
        /* 调用方法 - 根据 RecordNo 查询 RecordId */
        PhysicalExamRecordVo physicalExamRecordVo =  physicalExamRecordDaoAdapter.queryByNo(command.getRecordNo());

        /* 调用方法查询并返回 */
        PhysicalExamRecordDetailVo physicalExamRecordDetailVo= physicalExamRecordDetailDaoAdapter.queryById(physicalExamRecordVo.getId());

        return null;
    }
}
