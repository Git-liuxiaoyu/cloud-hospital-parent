package com.example.registerservice.service.command.addRegister;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.service.api.IAddRegisterCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/15:34
 * @Description:
 */
@Service
@Transactional
public class AddRegisterCommandHandler implements IAddRegisterCommandHandler {

    @Autowired
    private RegisterAdapter adapter;

    @Override
    public void action(AddRegisterCommand command) {
        try {
            adapter.insert(command);
        } catch (AdapterException e) {
            throw new AddRegisterException();
        }
    }
}
