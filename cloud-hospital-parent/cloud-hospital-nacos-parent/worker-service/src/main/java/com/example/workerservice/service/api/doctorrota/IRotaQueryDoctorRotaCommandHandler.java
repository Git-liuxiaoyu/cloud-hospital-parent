package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.service.command.doctorrota.rotaquery.RotaQueryDoctorRotaCommand;

import java.util.List;

/**
 * 接口 - IRotaQueryDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
public interface IRotaQueryDoctorRotaCommandHandler {

    List<RotaQueryDoctorRotaCommand.DoctorRotaVo> action(RotaQueryDoctorRotaCommand command);

}
