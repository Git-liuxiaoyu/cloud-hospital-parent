package com.example.takenumberservice.adapter;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.room.RoomServiceClient;
import com.example.takenumberservice.outlet.client.room.pojo.OutRoomVo;
import com.example.takenumberservice.outlet.dao.mysql.Proofdao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;


@Repository
public class ProofDaoAdapter {

    @Autowired
    private Proofdao proofdao;

    //openfeign接口
    @Autowired
    private RoomServiceClient roomServiceClient;

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
     * 排序查询获得第最大排队序号
     * @return
     */
    public Integer findorderNum(){

        return proofdao.findorderNum();
    }


}
