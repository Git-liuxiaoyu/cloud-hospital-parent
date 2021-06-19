package com.example.takenumberservice.service.command.findregister;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.example.takenumberservice.adapter.ProofDaoAdapter;
import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import com.example.takenumberservice.service.command.addProof.ProofCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class RegisterCommandHandle implements com.example.takenumberservice.service.api.RegisterCommandHandle {

    @Autowired
    private RegisterAdapter registerAdapter;


    @Override
    public ResponseResult<ProofCommand> findbyno(String no) {
        ResponseResult<RegisterCommand> findbyno = registerAdapter.findbyno(no);
        if(findbyno.getCode() != 200){
            return new ResponseResult<>(400,"未查询到挂号信息，请稍后重试",null);
        }else{
            ProofCommand proofCommand = new ProofCommand();
            ResponseResult<ProofCommand> execute = proofCommand.execute(findbyno.getData());
            return execute;
        }
    }
}
