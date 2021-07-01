package com.example.registerservice.service.command.updateregister;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.service.api.IUpdateRegisterCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/9:59
 * @Description:
 */
@Component
@Transactional
public class UpdateRegisterCommandHandler implements IUpdateRegisterCommandHandler {

    private final RegisterAdapter adapter;

    public UpdateRegisterCommandHandler(RegisterAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void action(UpdateRegisterCommand command) {
        try {
            adapter.update(command);
        } catch (AdapterException e) {
            throw new UpdateRegisterException();
        }
    }
}
