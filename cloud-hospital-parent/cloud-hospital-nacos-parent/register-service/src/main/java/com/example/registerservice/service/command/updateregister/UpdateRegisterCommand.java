package com.example.registerservice.service.command.updateregister;

import com.example.registerservice.service.api.IUpdateRegisterCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/9:59
 * @Description:
 */
@Data
public class UpdateRegisterCommand implements Serializable {

    private Long id;
    private String status;

    private IUpdateRegisterCommandHandler handler;

    public UpdateRegisterCommand(Long id, String status) {
        this();
        this.id = id;
        this.status = status;
    }

    public UpdateRegisterCommand() {
        handler = ApplicationContextHolder.getApplicationContext().getBean(IUpdateRegisterCommandHandler.class);
    }

    public void execute(){
        handler.action(this);
    }
}
