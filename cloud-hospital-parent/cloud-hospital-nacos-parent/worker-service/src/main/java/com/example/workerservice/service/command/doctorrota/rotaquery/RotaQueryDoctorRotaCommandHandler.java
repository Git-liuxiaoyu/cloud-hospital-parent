package com.example.workerservice.service.command.doctorrota.rotaquery;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.service.api.doctorrota.IRotaQueryDoctorRotaCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 - IRotaQueryDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class RotaQueryDoctorRotaCommandHandler implements IRotaQueryDoctorRotaCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    public RotaQueryDoctorRotaCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<RotaQueryDoctorRotaCommand.DoctorRotaVo> action(RotaQueryDoctorRotaCommand command) {
        /* 执行方法 */
        return doctorRotaDaoAdapter.query(command.getDepartmentId(),command.getDate(),command.getShiftType(),DoctorRotaSetVo.STATUS_NORMAL);
    }
}
