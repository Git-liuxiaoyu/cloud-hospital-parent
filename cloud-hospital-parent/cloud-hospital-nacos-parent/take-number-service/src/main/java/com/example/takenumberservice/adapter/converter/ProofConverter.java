package com.example.takenumberservice.adapter.converter;

import com.example.takenumberservice.outlet.dao.mysql.pojo.PharmacyProofPo;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import org.springframework.stereotype.Component;

/**
 * 转换
 */
@Component
public class ProofConverter {

    /**
     * command转po挂号叫号
     * @return
     */
    public ProofPo CoToPo(ProofCommand proofCommand){
        ProofPo po = new ProofPo();
        po.setId(proofCommand.getId());
        po.setNo(proofCommand.getNo());
        po.setRegId(proofCommand.getRegId());
        po.setDepartmentId(proofCommand.getDepartmentId());
        po.setCreateTime(proofCommand.getCreateTime());
        po.setOrderNum(proofCommand.getOrderNum());
        po.setRoomName(proofCommand.getRoomName());
        po.setStatus(proofCommand.getStatus());
        return po;
    }

    /**
     * command转po药房取票
     * @return
     */
    public PharmacyProofPo CoToPo2(PharmacyProofCommand proofCommand){
        PharmacyProofPo po = new PharmacyProofPo();
        po.setNo(proofCommand.getNo());
        po.setOrderNum(proofCommand.getOrderNum());
        po.setCreateTime(proofCommand.getCreateTime());

        return po;
    }



}
