package com.example.takenumberservice.adapter;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.room.RoomServiceClient;
import com.example.takenumberservice.outlet.dao.mysql.Proofdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
    public String findbyroomid(Integer id){

        try {

            ResponseResult<String> findbyid = roomServiceClient.findbyid(id);

            return findbyid.getData();
            //return "就诊室";
        }catch (Exception e){
            e.printStackTrace();
            return null;
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
