package com.example.workerservice.service.api.division;

import com.example.workerservice.inlet.web.vo.DivisionVo;

import java.util.List;

/**
 * 接口 - QueryAllDeparmentCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
public interface IQueryAllDivisionCommandHandler {

    List<DivisionVo> action();

}
