package com.example.takenumberservice.adapter.converter;

import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import com.example.takenumberservice.service.command.addProof.ProofCommand;

/**
 * 转换
 */
public class ProofConverter {

    /**
     * command转po
     * @return
     */
    public ProofPo CoToPo(ProofCommand proofCommand){
        ProofPo po = new ProofPo();
        po.setId(proofCommand.getId());
        po.setRegId(proofCommand.getRegId());
        po.setDepartmentId(proofCommand.getDepartmentId());
        po.setCreateTime(proofCommand.getCreateTime());
        po.setOrderNum(proofCommand.getOrderNum());
        po.setRoomName(proofCommand.getRoomName());
        po.setStatus(proofCommand.getStatus());
        return po;
    }

}
