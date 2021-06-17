package com.example.registerservice.service.query.GetPhoneAndCode;

import com.example.registerservice.adapter.RegisterDaoAdapter;
import com.example.registerservice.service.api.IQueuePhoneAndCodeCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/17:19
 * @Description:
 */
@Component
@Slf4j
public class QueuePhoneAndCodeCommandHandler implements IQueuePhoneAndCodeCommandHandler {

    @Autowired
    private RegisterDaoAdapter daoAdapter;

    @Override
    public boolean action(QueuePhoneAndCodeCommand command) {
        try {
            String code = daoAdapter.select(command);
            log.debug("验证码{}",code);
            if(!code.equals(command.getCode())){//说明输入的验证码不正确
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
