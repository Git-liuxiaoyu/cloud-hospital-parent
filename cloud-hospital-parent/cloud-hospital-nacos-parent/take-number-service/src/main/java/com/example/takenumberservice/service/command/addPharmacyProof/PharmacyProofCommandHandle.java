package com.example.takenumberservice.service.command.addPharmacyProof;

import com.example.takenumberservice.adapter.PharmacyProofDaoAdapter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.mq.SendMsg;
import com.example.takenumberservice.outlet.mq.pojo.MqPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class PharmacyProofCommandHandle implements com.example.takenumberservice.service.api.PharmacyProofCommandHandle {

    @Autowired
    private PharmacyProofDaoAdapter pharmacyProofDaoAdapter;




    /**
     * 添加药房取票凭证
     * @param addProof
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<PharmacyProofCommand> add(PharmacyProofCommand addProof) {
        //查询redis，是否存在no
        boolean noRedis = pharmacyProofDaoAdapter.findNoRedis(addProof.getNo());
        if(noRedis){//如果为true则代表redis中有该no则无操作返回
            return new ResponseResult<>(999,"已出票，请勿重复取票",null);
        }

        ResponseResult<Void> byNo = pharmacyProofDaoAdapter.findByNo(addProof.getNo());
        if(byNo.getCode() != 200){
            return new ResponseResult<PharmacyProofCommand>(500,"未查询到取药信息，请稍后重试！",null);
        }else{
            Integer integer = pharmacyProofDaoAdapter.findorderNum();//查询到最大排队序号，没有则为0
            //定义时间格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date = new Date();//当前系统时间
            String thistime = df.format(date);// thistime为当前时间
            addProof.setOrderNum(integer+1);
            addProof.setCreateTime(thistime);
            int i = pharmacyProofDaoAdapter.addProof(addProof);
            if(i>0){
                pharmacyProofDaoAdapter.sendPharmacy(integer+1, addProof.getNo());//发送消息

                //存入redis
                pharmacyProofDaoAdapter.addNoRedis(addProof.getNo());
                return new ResponseResult<PharmacyProofCommand>(200,"ok",addProof);
            }else{
                return new ResponseResult<PharmacyProofCommand>(500,"取票失败，请稍后再试",null);
            }
        }
    }
}
