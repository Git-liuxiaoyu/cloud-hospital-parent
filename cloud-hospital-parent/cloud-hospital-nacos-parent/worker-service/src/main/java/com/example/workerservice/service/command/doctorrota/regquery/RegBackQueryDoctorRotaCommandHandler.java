package com.example.workerservice.service.command.doctorrota.regquery;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IRegBackQueryDoctorRotaCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 接口实现类 - 实现 - IRegQueryDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class RegBackQueryDoctorRotaCommandHandler implements IRegBackQueryDoctorRotaCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    public RegBackQueryDoctorRotaCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> action(RegBackQueryDoctorRotaCommand command) {
        /* 查询到基本的数据 */
        /* 返回 */
        String currentDate = new Date().toString();
        /* LOG */
        log.info("查询的日期为今日 : [{}]", currentDate);
        try {
            return doctorRotaDaoAdapter.backQuery(new SimpleDateFormat("yyyy-MM-dd").parse(currentDate), command.getDepartmentId(), DoctorRotaVo.STATUS_NORMAL, command.getDoctorType(), command.getShiftType());
        } catch (ParseException e) {
            throw new NewDateParseException();
        }
    }


}
