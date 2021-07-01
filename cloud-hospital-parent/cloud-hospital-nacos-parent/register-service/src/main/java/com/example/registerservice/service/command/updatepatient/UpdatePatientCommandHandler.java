package com.example.registerservice.service.command.updatepatient;

import com.example.registerservice.adapter.PatientAdepter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.service.api.IUpdatePatientCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/23/14:41
 * @Description:
 */
@Component
@Transactional
public class UpdatePatientCommandHandler implements IUpdatePatientCommandHandler {

    @Autowired
    private PatientAdepter adepter;

    @Override
    public void action(UpdatePatientCommand command) {
        try {
            adepter.update(command);
        } catch (AdapterException e) {
            /*抛出修改的异常*/
            throw new UpdatePatientException();
        }
    }
}
