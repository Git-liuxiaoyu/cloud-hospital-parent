package com.example.takenumberservice.service.api;

import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.service.command.ProofCommand;

public interface ProofCommandHandle {

    ProofControllerVo findbyregId (Integer regId);//通过挂号id查询取号信息
}
