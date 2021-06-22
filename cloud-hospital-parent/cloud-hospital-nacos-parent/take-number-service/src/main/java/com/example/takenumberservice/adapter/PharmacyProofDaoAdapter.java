package com.example.takenumberservice.adapter;


import com.example.takenumberservice.adapter.converter.ProofConverter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.drugodd.DrugoddClient;
import com.example.takenumberservice.outlet.dao.mysql.PharmacyProofDao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.PharmacyProofPo;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import com.example.takenumberservice.outlet.dao.redis.PharmacyRedisDao;
import com.example.takenumberservice.outlet.dao.redis.pojo.PharmacyRedisPo;
import com.example.takenumberservice.outlet.dao.redis.pojo.ProofRedisPo;
import com.example.takenumberservice.outlet.mq.SendMsg;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 药房取票适配器层
 */
@Repository
@Slf4j
public class PharmacyProofDaoAdapter {

    @Autowired
    private PharmacyProofDao proofDao;

    @Autowired
    private ProofConverter proofConverter;

    @Autowired
    private PharmacyRedisDao pharmacyRedisDao;

    @Autowired
    private SendMsg sendMsg;


    /**
     * 添加进mysql
     * @return
     */
    public int addProof(PharmacyProofCommand proofCommand){
        ProofConverter pc = new ProofConverter();
        PharmacyProofPo pharmacyProofPo = proofConverter.CoToPo2(proofCommand);//转换

        int addproof = proofDao.addproof(pharmacyProofPo);//添加
        return addproof;
    }

    /**
     * 排序查询获得第最大排队序号
     * @return
     */
    public Integer findorderNum() {
        Integer i = 0;
        try {
            i = proofDao.findorderNum();
        }catch (Exception e){
            return 0;
        }
        return i;
    }


    /**
     * 查询openfeign有没有该编码
     * @return
     */
    public ResponseResult<Void> findByNo(String no){
        //ResponseResult<Void> byYFNo = drugoddClient.findByYFNo(no);
        ResponseResult<Void> byYFNo = new ResponseResult<>(200,"无",null);
            return byYFNo;

    }


    /**
     * 给药房微服务发消息
     * 序号加no
     */
    public void sendPharmacy(Integer orderNo,String No){
        sendMsg.Sendpharmacy(orderNo,No);

    }



    //查询redis中是否有no
    public boolean findNoRedis(String no) {
        Optional<PharmacyRedisPo> byId = pharmacyRedisDao.findById(no);
        System.out.println("redis中查的"+byId.isPresent());
        if(byId.isPresent()){
            log.info("已查询出redis存在该数据no:{}",byId.get().getNo());
            return true;
        }else {
            return false;
        }
    }

    //把no存入redis
    public void addNoRedis(String no) {
        PharmacyRedisPo redisPo = new PharmacyRedisPo(no);
        pharmacyRedisDao.save(redisPo);
        log.info("执行保存no功能{}",no);
    }




}
