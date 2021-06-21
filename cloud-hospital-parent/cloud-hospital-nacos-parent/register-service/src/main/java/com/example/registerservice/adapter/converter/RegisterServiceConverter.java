package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.service.command.addRegister.AddRegisterCommand;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/16:34
 * @Description:
 */
@Component
public class RegisterServiceConverter {

    public RegisterMysqlPo converter(AddRegisterCommand command){
        RegisterMysqlPo po=new RegisterMysqlPo();
        po.setNo(command.getNo());
        po.setPatientid(command.getPatientId());
        po.setRegtype(command.getRegType());
        po.setRegtime(command.getRegTime());
        po.setRegtime(command.getRegTime());
        po.setRotaid(command.getRotaId());
        po.setDepartmentid(command.getDepartmentId());
        po.setVisitsection(command.getVisitSection());
        po.setPrice(command.getPrice());
        po.setType(command.getType());
        po.setStatus(command.getStatus());
        po.setVisittime(command.getVisitTime());
        return po;
    }
}
