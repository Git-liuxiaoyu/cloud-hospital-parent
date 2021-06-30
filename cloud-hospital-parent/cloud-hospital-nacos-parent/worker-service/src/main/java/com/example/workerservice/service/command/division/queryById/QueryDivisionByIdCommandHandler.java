package com.example.workerservice.service.command.division.queryById;

import com.example.workerservice.adapter.DivisionDaoAdapter;
import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.service.api.division.IQueryDivisionByIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IQueryDivisionByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Component
@Slf4j
public class QueryDivisionByIdCommandHandler implements IQueryDivisionByIdCommandHandler {

    /* 构造方法 - 开始 */
    private final DivisionDaoAdapter divisionDaoAdapter;

    public QueryDivisionByIdCommandHandler(DivisionDaoAdapter divisionDaoAdapter) {
        this.divisionDaoAdapter = divisionDaoAdapter;
    }

    /* 构造方法 - 结束 */
    @Override
    public DivisionVo action(QueryDivisionByIdCommand command) {
        DivisionVo  divisionVo = null;

        try {
            /* 执行方法 */
            divisionVo = divisionDaoAdapter.queryById(command.getDivisionId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        /* 返回 */
        return divisionVo;
    }
}
