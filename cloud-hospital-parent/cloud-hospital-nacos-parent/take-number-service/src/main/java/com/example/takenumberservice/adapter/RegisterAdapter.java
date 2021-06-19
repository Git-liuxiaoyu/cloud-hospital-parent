package com.example.takenumberservice.adapter;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.RegisterServiceClient;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import com.example.takenumberservice.outlet.client.room.pojo.OutRoomVo;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 挂号微服务相关操作适配器
 */
@Repository
public class RegisterAdapter {

    //openfeign接口
    @Autowired
    private RegisterServiceClient registerServiceClient;

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
                    rc.setStatus(findbyno.getData().getVisitSection());//挂号状态
                    return new ResponseResult<RegisterCommand>(200,"ok",rc);
                }
                //return "就诊室";
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseResult<RegisterCommand>(400,"未查询到挂号信息，请稍后重试！",null);
            }



            //===================================================================
//            Register re = new Register();
//
//            re.setId(1L);//获得挂号id
//            re.setNo("GH1001");//获得挂号编码
//            re.setDepartmentId(1);//科室id
//            re.setRoomId(1);//房间id
//            re.setVisitSection("2");//就诊时间段
//            re.setStatus("3");//挂号状态
//
//            ResponseResult<Register> findbyno = new ResponseResult<>(200,"ok",re);
//===============================================================================================


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
