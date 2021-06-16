package com.example.takenumberservice.adapter;


import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.outlet.dao.mysql.ProofDao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.Proof;
import com.example.takenumberservice.service.command.ProofCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProofDaoAdapter {

    @Autowired
    private com.example.takenumberservice.outlet.dao.mysql.ProofDao ProofDao;

    public ProofControllerVo findbyregId(Integer regId){


        //从数据库查
        Proof proof = ProofDao.findbyregId(regId);
        ProofControllerVo vo = new ProofControllerVo();
        vo.setId(proof.getId());
        vo.setRegId(proof.getRegId());
        vo.setDepartmentId(proof.getDepartmentId());
        vo.setOrderNum(proof.getOrderNum());
        vo.setRoomName(proof.getRoomName());
        vo.setCreateTime(proof.getCreateTime());
        vo.setStatus(proof.getStatus());
        return vo;

    }

}
