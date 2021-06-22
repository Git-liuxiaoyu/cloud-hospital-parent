package com.example.takenumberservice.service.api;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;

public interface ProofCommandHandle {

    public ResponseResult<ProofCommand> add(RegisterCommand findbyno);
}
