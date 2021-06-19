package com.example.workerservice.service.api.user;

import com.example.workerservice.service.command.user.savelogintoken.SaveLoginTokenByIPCommand;

/**
 * 接口 - ILoginTokenCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
public interface ISaveLoginTokenByIPCommandHandler {

    String action(SaveLoginTokenByIPCommand command);

}
