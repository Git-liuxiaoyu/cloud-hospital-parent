package com.example.takenumberservice.inlet.web.controller;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.service.command.addProof.ProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/proof/")
public class ProofController {

    @GetMapping("findbyno/{no}")
    public ResponseResult<ProofCommand> findbyregId(@PathVariable("no") String no){
        RegisterCommand rc = new RegisterCommand();
        rc.setNo(no);
        return rc.execute();
    }

}
