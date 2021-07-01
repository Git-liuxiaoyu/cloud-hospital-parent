package com.example.registerservice.service.query.queryphoneandcode;

import com.example.registerservice.adapter.RegisterAdapter;
import com.example.registerservice.service.api.IQueryPhoneAndCodeCommandHandler;
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
public class QueryPhoneAndCodeCommandHandler implements IQueryPhoneAndCodeCommandHandler {

    @Autowired
    private RegisterAdapter daoAdapter;

    @Override
    public void action(QueryPhoneAndCodeCommand command) {
        try {
            daoAdapter.select(command);
            log.debug("验证码{}可以匹配", command.getCode());
        } catch (NullPointerException e) {
            throw new QueryPhoneAndCodeException();
        }

    }
}
