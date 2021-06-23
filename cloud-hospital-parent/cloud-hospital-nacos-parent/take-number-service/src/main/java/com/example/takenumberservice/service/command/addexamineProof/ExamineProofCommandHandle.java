package com.example.takenumberservice.service.command.addexamineProof;

import com.example.takenumberservice.adapter.ExaminePeoofDaoAdapter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExamineProofCommandHandle implements com.example.takenumberservice.service.api.ExamineProofCommandHandle {


    @Autowired
    private ExaminePeoofDaoAdapter examinePeoofDaoAdapter;

    /**
     * 添加检查取票凭证
     * @param addexamine
     * @return
     */
    @Override
    public ResponseResult<ExamineProofCommand> add(ExamineProofCommand addexamine) {

        //先查redis
        boolean noRedis = examinePeoofDaoAdapter.findNoRedis(addexamine.getNo());

        if(noRedis){//如果为true则代表redis中有该no则无操作返回
            return new ResponseResult<ExamineProofCommand>(999,"已出票，请勿重复取票",null);
        }

        ResponseResult<ExamineProofCommand> findbyno = examinePeoofDaoAdapter.findbyno(addexamine.getNo());
        if(findbyno.getCode() != 200){
            return new ResponseResult<ExamineProofCommand>(400,"未查询到检查单信息，请稍后重试！",null);
        }else{
            //查询数据库获得排序
            Integer orderNum = examinePeoofDaoAdapter.findOrderNum(findbyno.getData().getExamineType());
            //存入数据库
            //定义时间格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date = new Date();//当前系统时间
            String thistime = df.format(date);// thistime为当前时间
            findbyno.getData().setOrderNum(orderNum+1);
            findbyno.getData().setCreateTime(thistime);
            findbyno.getData().setNo(addexamine.getNo());
            int i = examinePeoofDaoAdapter.addProof(findbyno.getData());
            if(i>0){
                //存入redis
                examinePeoofDaoAdapter.addNoRedis(addexamine.getNo());
                //发送消息
                examinePeoofDaoAdapter.sendexamine(findbyno.getData().getNo(), orderNum+1);
                return new ResponseResult<ExamineProofCommand>(200,"ok",findbyno.getData());
            }else{
                return new ResponseResult<ExamineProofCommand>(500,"检查取票机内部错误，请联系维修人员",null);
            }

        }
    }
}
