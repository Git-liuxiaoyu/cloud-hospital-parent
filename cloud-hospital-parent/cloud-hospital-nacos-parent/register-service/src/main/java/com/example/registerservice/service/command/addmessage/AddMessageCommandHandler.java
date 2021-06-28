package com.example.registerservice.service.command.addmessage;

import com.example.registerservice.adapter.MessageAdepter;
import com.example.registerservice.service.api.IAddMessageCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/10:43
 * @Description:
 */
@Component
public class AddMessageCommandHandler implements IAddMessageCommandHandler {

    @Autowired
    private MessageAdepter adepter;

    @Override
    public void action(AddMessageCommand command) {
        adepter.insert(command);
    }
}
