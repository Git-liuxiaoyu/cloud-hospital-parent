package com.example.takenumberservice.service.api;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;

/**
 * 调用挂号微服务方法的接口
 */
public interface RegisterCommandHandle {

    public ResponseResult<ProofCommand> findbyno(String no);
}
