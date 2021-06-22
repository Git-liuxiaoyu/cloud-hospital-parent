package com.example.workerservice.service.command.doctorrota.querybyid;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IQueryDoctorRotaByIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 - IQueryDoctorRotaByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Slf4j
@Component
public class QueryDoctorRotaByIdCommandHandler implements IQueryDoctorRotaByIdCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    public QueryDoctorRotaByIdCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public DoctorRotaVo action(QueryDoctorRotaByIdCommand command) {
        return doctorRotaDaoAdapter.query(command.getId());
    }
}
