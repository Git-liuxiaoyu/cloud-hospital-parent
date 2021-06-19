package com.example.workerservice.service.command.user.savelogintoken;

import com.example.workerservice.service.api.user.ISaveLoginTokenByIPCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * 实体类 - 命令 - SaveLoginTokenByIP
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
public class SaveLoginTokenByIPCommand {

    private String ip;

    private ISaveLoginTokenByIPCommandHandler saveLoginTokenByIPCommandHandler;

    public SaveLoginTokenByIPCommand() {
        this.saveLoginTokenByIPCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(ISaveLoginTokenByIPCommandHandler.class);
    }

    public SaveLoginTokenByIPCommand(String ip) {
        this();
        this.ip = ip;
    }

    public String execute(){
        /* 执行方法 */
        return this.saveLoginTokenByIPCommandHandler.action(this);
    }
}
