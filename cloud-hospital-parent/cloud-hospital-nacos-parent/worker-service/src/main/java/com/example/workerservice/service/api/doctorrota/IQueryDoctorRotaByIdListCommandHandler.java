package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.command.doctorrota.querybyid.QueryDoctorRotaByIdListCommand;

import java.util.List;

/**
 * 接口 - IQueryDoctorRotaByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface IQueryDoctorRotaByIdListCommandHandler {

    List<DoctorRotaVo> action(QueryDoctorRotaByIdListCommand command);

}
