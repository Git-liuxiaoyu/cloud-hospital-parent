package com.example.takenumberservice.service.api;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addProof.ProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;

/**
 * 调用挂号微服务方法的接口
 */
public interface RegisterCommandHandle {

    public ResponseResult<ProofCommand> findbyno(String no);
}
