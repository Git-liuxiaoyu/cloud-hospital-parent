package com.example.takenumberservice.service.command;

import com.example.takenumberservice.adapter.ProofDaoAdapter;
import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.service.api.ProofCommandHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProofCommandHandler implements ProofCommandHandle {

    @Autowired
    private ProofDaoAdapter proofDaoAdapter;

    @Override
    public ProofControllerVo findbyregId(Integer regId) {
        ProofControllerVo vo = proofDaoAdapter.findbyregId(regId);
        return vo;
    }
}
