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
        /* 找个日期 */
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        Date parse = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd").parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /* LOG */
        log.info("查询的日期为今日 : [{}]", parse);
        /* 执行方法并返回 */
        return doctorRotaDaoAdapter.backQuery(parse, command.getDepartmentId(), DoctorRotaVo.STATUS_NORMAL, command.getDoctorType(), command.getShiftType());

    }


}
