package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.outlet.client.po.DepartmentClientPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/18:45
 * @Description:
 */
@Component
public class RegisterVoConverter {
    /**
     * 科目的集合ClientPo对象转换科目的集合vo对象
     *
     * @param clientPoList
     * @return
     */
    public List<RegisterVo> convert(List<RegisterMysqlPo> clientPoList) {
        List<RegisterVo> RegisterVoList = new ArrayList<>();
        clientPoList.forEach(item -> RegisterVoList.add(convert(item)));
        return RegisterVoList;
    }


    /**
     * 科目的ClientPo对象转换科目的vo对象
     *
     * @param clientPo
     * @return
     */
    public RegisterVo convert(RegisterMysqlPo clientPo) {
        RegisterVo vo=new RegisterVo();
        vo.setId(clientPo.getId());
        vo.setNo(clientPo.getNo());
        vo.setDepartmentId(clientPo.getDepartmentid());
        vo.setRoomId(clientPo.getRoomid());
        vo.setVisitSection(clientPo.getVisitsection());
        vo.setStatus(clientPo.getStatus());
        return vo;
    }
}
