package com.example.registerservice.service.api;

import com.example.registerservice.service.query.GetPhoneAndCode.QueuePhoneAndCodeCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/17:16
 * @Description:
 */
public interface IQueuePhoneAndCodeCommandHandler {
    boolean action(QueuePhoneAndCodeCommand command);
}
