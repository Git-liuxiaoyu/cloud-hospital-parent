package com.example.workerservice.service.command.division.queryall;

import com.example.workerservice.adapter.DivisionDaoAdapter;
import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.service.api.division.IQueryAllDivisionCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 -IQueryAllDivisionCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Slf4j
@Component
public class QueryAllDivisionCommandHandler implements IQueryAllDivisionCommandHandler {

    /* 构造注入 - 开始 */
    private final DivisionDaoAdapter divisionDaoAdapter;

    public QueryAllDivisionCommandHandler(DivisionDaoAdapter divisionDaoAdapter) {
        this.divisionDaoAdapter = divisionDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<DivisionVo> action() {
        /* 调用方法并返回 */
        return divisionDaoAdapter.queryAllByStatus(DivisionVo.STATUS_NORMAL);
    }
}
