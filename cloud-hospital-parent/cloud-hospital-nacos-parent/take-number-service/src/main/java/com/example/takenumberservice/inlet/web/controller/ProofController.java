package com.example.takenumberservice.inlet.web.controller;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/GHproof/")
public class ProofController {


    @GetMapping("findbyno/{no}")
    public ResponseResult<ProofCommand> findbyregId(@PathVariable("no") String no){
        RegisterCommand rc = new RegisterCommand();
        rc.setNo(no);
        return rc.execute();
    }

}
