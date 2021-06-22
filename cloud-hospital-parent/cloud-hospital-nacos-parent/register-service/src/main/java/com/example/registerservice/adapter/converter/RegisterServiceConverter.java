package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterOrderMysqlPo;
import com.example.registerservice.service.command.addRegister.AddRegisterCommand;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/16:34
 * @Description:
 */
@Component
public class RegisterServiceConverter {

    public RegisterMysqlPo converter(AddRegisterCommand command) {
        RegisterMysqlPo po = new RegisterMysqlPo();
        po.setNo(command.getNo());
        po.setPatientid(command.getPatientId());
        po.setRegtype(command.getRegType());
        po.setRegtime(command.getRegTime());
        po.setRotaid(command.getRotaId());
        po.setDepartmentid(command.getDepartmentId());
        po.setVisitsection(command.getVisitSection());
        po.setPrice(command.getPrice());
        po.setType(command.getType());
        po.setStatus(command.getStatus());
        po.setVisittime(command.getVisitTime());
        po.setPhone(command.getPhone());
        return po;
    }

    /**
     * RegisterOrderMysqlPo转RegisterServicePo方法
     *
     * @param po
     * @return
     */
    public RegisterServicePo converter(RegisterOrderMysqlPo po) {
        RegisterServicePo servicePo = new RegisterServicePo();
        servicePo.setId(po.getId());
        servicePo.setNo(po.getNo());
        servicePo.setRegTime(po.getRegTime());
        servicePo.setDepartmentId(po.getDepartmentId());
        servicePo.setRotaId(po.getRotaId());
        servicePo.setPrice(po.getPrice());
        servicePo.setType(po.getType());
        servicePo.setStatus(po.getStatus());
        servicePo.setName(po.getName());
        return servicePo;
    }

    /**
     * 根据RegisterOrderMysqlPoList转RegisterServicePoList方法
     *
     * @param servicePoList
     * @return
     */
    public List<RegisterServicePo> converter(List<RegisterOrderMysqlPo> servicePoList) {
        List<RegisterServicePo> servicePos=new ArrayList<>();
        servicePoList.forEach(item->servicePos.add(converter(item)));
        return servicePos;
    }
}
