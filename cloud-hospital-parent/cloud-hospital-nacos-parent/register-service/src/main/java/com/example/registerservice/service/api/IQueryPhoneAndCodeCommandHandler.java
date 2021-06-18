package com.example.registerservice.service.api;

import com.example.registerservice.service.query.queryphoneandcode.QueryPhoneAndCodeCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/17:16
 * @Description: 用户登入验证接口
 */
public interface IQueryPhoneAndCodeCommandHandler {
    boolean action(QueryPhoneAndCodeCommand command);
}
