package com.example.workerservice.service.api.division;

import com.example.workerservice.service.command.division.add.AddDivisionCommand;
import com.example.workerservice.service.command.division.update.UpdateDivisionCommand;

/**
 * 接口 -  IUpdateDivisionCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
public interface IUpdateDivisionCommandHandler {

    void action(UpdateDivisionCommand command);

}
