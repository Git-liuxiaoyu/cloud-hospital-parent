package com.example.workerservice.service.command.doctorrota.querylistbyidlist;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IQueryDoctorRotaListByIdListCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 -
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class QueryDoctorRotaByIdListCommandHandler implements IQueryDoctorRotaListByIdListCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    public QueryDoctorRotaByIdListCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<QueryDoctorRotaListByIdListCommand.DoctorRotaVo> action(QueryDoctorRotaListByIdListCommand command) {
        /* 调用方法 */
        return doctorRotaDaoAdapter.query(command.getIdList());
    }

}
