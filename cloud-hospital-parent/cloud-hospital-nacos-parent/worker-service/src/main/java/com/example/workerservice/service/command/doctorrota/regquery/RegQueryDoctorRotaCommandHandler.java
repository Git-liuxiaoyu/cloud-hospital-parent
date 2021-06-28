package com.example.workerservice.service.command.doctorrota.regquery;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IRegQueryDoctorRotaCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 - IRegQueryDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class RegQueryDoctorRotaCommandHandler implements IRegQueryDoctorRotaCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    public RegQueryDoctorRotaCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<RegQueryDoctorRotaCommand.DoctorRotaVo> action(RegQueryDoctorRotaCommand command) {
        /* 查询到基本的数据 */
        /* 返回 */
        return doctorRotaDaoAdapter.query(command.getDate(), command.getDepartmentId(), DoctorRotaVo.STATUS_NORMAL);
    }


}
