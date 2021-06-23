package com.example.registerservice.service.api;

import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.command.updateregister.UpdateRegisterCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/9:58
 * @Description:
 */
public interface IUpdatePatientCommandHandler {
    void action(UpdatePatientCommand command);
}
