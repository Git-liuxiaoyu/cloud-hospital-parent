package com.example.takenumberservice.adapter;


import com.example.takenumberservice.adapter.converter.ProofConverter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.room.RoomServiceClient;
import com.example.takenumberservice.outlet.client.room.pojo.OutRoomVo;
import com.example.takenumberservice.outlet.dao.mysql.ProofDao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import com.example.takenumberservice.outlet.mq.SendMsg;
import com.example.takenumberservice.outlet.mq.pojo.MqPo;
import com.example.takenumberservice.service.command.addProof.ProofCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class ProofDaoAdapter {

    @Autowired
    private ProofDao proofdao;

    //openfeign接口
    @Autowired
    private RoomServiceClient roomServiceClient;

    @Autowired
    private SendMsg sendMsg;




    /**
     * 添加进mysql
     * @return
     */
    public int addProof(ProofCommand proofCommand){
        ProofConverter pc = new ProofConverter();
        ProofPo proofPo = pc.CoToPo(proofCommand);

        int addproof = proofdao.addproof(proofPo);
        return addproof;
    }

    /**
     * 根据房间id查询房间名字
     * @return
     */
    public ResponseResult<OutRoomVo> findbyroomid(Integer id){

        try {

            ResponseResult<OutRoomVo> findbyid = roomServiceClient.findbyid(id);

            if(findbyid.getCode() != 200){
                return new ResponseResult<OutRoomVo>(400,"未查询到房间名",null);
            }else{
                return new ResponseResult<OutRoomVo>(200,"ok",findbyid.getData());
            }
            //return "就诊室";
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<OutRoomVo>(400,"未查询到房间名",null);
        }

    }

    /**
     * 给队列发送消息，叫号微服务接受
     */
    public void send(MqPo po){

        sendMsg.SendPatient(po);
    }

    /**
     * 排序查询获得第最大排队序号
     * @return
     */
    public Integer findorderNum() {
        Integer i = 0;
        try {
            i = proofdao.findorderNum();
        }catch (Exception e){
          return 0;
        }
        return i;
    }


}
