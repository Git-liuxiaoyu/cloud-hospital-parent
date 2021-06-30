package com.example.workerservice.service.api.division;

import com.example.workerservice.service.command.division.add.AddDivisionCommand;

/**
 * 接口 -  IAddDivisionCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
public interface IAddDivisionCommandHandler {

    void action(AddDivisionCommand command);

}
