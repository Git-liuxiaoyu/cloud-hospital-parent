package com.example.takenumberservice.adapter;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.RegisterServiceClient;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import com.example.takenumberservice.outlet.client.room.pojo.OutRoomVo;
import com.example.takenumberservice.outlet.dao.redis.ProofRedisDao;
import com.example.takenumberservice.outlet.dao.redis.pojo.ProofRedisPo;
import com.example.takenumberservice.service.command.addProof.ProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 挂号微服务相关操作适配器
 */
@Repository
@Slf4j
public class RegisterAdapter {

    //openfeign接口
    @Autowired
    private RegisterServiceClient registerServiceClient;

    //reids
    @Autowired
    private ProofRedisDao proofRedisDao;

    /**
     * 向openfeign发送获取挂号信息请求
     * @return
     */

    public ResponseResult<RegisterCommand> findbyno(String no){
        try{
            ResponseResult<Register> findbyno = registerServiceClient.findbyno(no);

                if(findbyno.getCode() != 200){
                    return new ResponseResult<RegisterCommand>(400,"未查询到挂号信息，请稍后重试！",null);
                }else{
                    RegisterCommand rc = new RegisterCommand();
                    rc.setId(findbyno.getData().getId());//获得挂号id
                    rc.setNo(findbyno.getData().getNo());//获得挂号编码
                    rc.setDepartmentId(findbyno.getData().getDepartmentId());//科室id
                    rc.setRoomId(findbyno.getData().getRoomId());//房间id
                    rc.setVisitSection(findbyno.getData().getVisitSection());//就诊时间段
                    rc.setStatus(findbyno.getData().getStatus());//挂号状态
                    return new ResponseResult<RegisterCommand>(200,"ok",rc);
                }
                //return "就诊室";
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseResult<RegisterCommand>(400,"未查询到挂号信息，请稍后重试！",null);
            }

    }

    //查询redis中是否有no
    public boolean findNoRedis(String no) {
        Optional<ProofRedisPo> byId = proofRedisDao.findById(no);
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
        ProofRedisPo redisPo = new ProofRedisPo(no);
        proofRedisDao.save(redisPo);
        log.info("执行保存no功能{}",no);
    }

    //把no从redis删除
    public void deleteNoRedis(String no) {
        ProofRedisPo redisPo = new ProofRedisPo(no);
        proofRedisDao.delete(redisPo);
        log.info("执行删除no功能{}",no);
    }





    /**
     * 修改挂号状态
     * @param id
     * @param status
     */

    public void updatebyid(Long id ,Integer status){
        System.out.println("修改挂号状态");
        //registerServiceClient.updatestatus(id,status);
    }
}
