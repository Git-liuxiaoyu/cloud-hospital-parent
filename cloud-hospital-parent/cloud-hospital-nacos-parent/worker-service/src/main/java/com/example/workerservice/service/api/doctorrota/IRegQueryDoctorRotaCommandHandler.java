package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.command.doctorrota.regquery.RegQueryDoctorRotaCommand;

import java.util.List;

/**
 * 接口 - IRegQueryDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
public interface IRegQueryDoctorRotaCommandHandler {

    List<DoctorRotaVo> action(RegQueryDoctorRotaCommand command);

}
