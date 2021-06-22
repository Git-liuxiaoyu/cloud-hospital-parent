package com.example.takenumberservice.service.command.addCallProof;

import com.example.takenumberservice.adapter.ProofDaoAdapter;
import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.doctor.pojo.DoctorRotaVo;
import com.example.takenumberservice.outlet.client.doctor.pojo.OutRoomVo;
import com.example.takenumberservice.outlet.mq.SendMsg;
import com.example.takenumberservice.outlet.mq.pojo.MqPo;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
@Slf4j
public class ProofCommandHandle implements com.example.takenumberservice.service.api.ProofCommandHandle {

    @Autowired
    private ProofDaoAdapter proofDaoAdapter;

    @Autowired
    private RegisterAdapter registerAdapter;




    @Override
    public ResponseResult<ProofCommand> add(RegisterCommand findbyno) {

        //判断时间是否正确
        //定义时间格式
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
        Calendar calendar = new GregorianCalendar();//加日期对象

        Date date = new Date();//当前系统时间
        String thistime = df.format(date);// thistime为当前时间
        if(findbyno.getVisitSection().equals("1")){//如果就诊时间段为上午
            String amend = "12:00:00";
            String amstart = "09:00:00";
            Integer i=thistime.compareTo(amend);//如果是正数则代表当前系统时间大于上午12点,不让取票
            Integer k=amstart.compareTo(thistime);//如果是正数则代表当前系统时间小于上午9点，不让取票
            if(i>0){
                return new ResponseResult<>(400,"上午取票时间已过，请重新挂号",null);
            }else if(k>0){
                return new ResponseResult<>(400,"还未到上午取票时间，请稍后重试",null);
            }
        }else{//反之，就诊时间段为下午
            String pmstart = "14:00:00";
            String pmend = "18:00:00";
            Integer i=thistime.compareTo(pmend);//如果是正数则代表当前系统时间大于下午12点,不让取票
            Integer k=pmstart.compareTo(thistime);//如果是正数则代表当前系统时间小于下午14点，不让取票
            if(i>0){
                return new ResponseResult<>(400,"下午取票时间已过，请重新挂号",null);
            }else if(k>0){
                return new ResponseResult<>(400,"还未到下午取票时间，请稍后重试",null);
            }
        }
        //往取票表里存数据,service 调service
        ProofCommand proofCommand = new ProofCommand();
        ResponseResult<OutRoomVo> findbyroomid = proofDaoAdapter.findbyroomid(1l);//根据房间id查询房间名
        String roomName = findbyroomid.getData().getRoomname();

        proofCommand.setNo(findbyno.getNo());//挂号码
        proofCommand.setRegId(findbyno.getId());//挂号id
        proofCommand.setDepartmentId(findbyno.getDepartmentId());//科室id
        proofCommand.setRoomName(roomName);//房间名
        Integer orderNum = proofDaoAdapter.findorderNum();//最新的排队序号
        //Integer orderNum = null;
        if(orderNum == null){
            orderNum = 0;
        }
        proofCommand.setOrderNum(orderNum+1);

        //定义时间格式
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date2 = new Date();//当前系统时间
        String thistime2 = df2.format(date2);// thistime为当前时间

        proofCommand.setCreateTime(thistime2);
        if(findbyno.getStatus().equals("3") || findbyno.getStatus().equals("5")){
            proofCommand.setStatus("1");//设置取票状态为初诊票
            //修改挂号状态为已取初诊票
            registerAdapter.updatebyid(findbyno.getId(),"4");

        }else if(findbyno.getStatus().equals("6") || findbyno.getStatus().equals("8")){
            proofCommand.setStatus("2");//设置取票状态为复诊票
            //修改挂号状态为已取复诊票
            registerAdapter.updatebyid(findbyno.getId(),"7");
        }
        proofCommand.setNo(findbyno.getNo());
        //存入取票凭证表
        int i = proofDaoAdapter.addProof(proofCommand);
        log.info("存入取票凭证");


        if(i>0){
        //通过排班id获取医生信息
            ResponseResult<DoctorRotaVo> doctorRotaById = proofDaoAdapter.getDoctorRotaById(findbyno.getRotaId());
            if(doctorRotaById.getCode() != 200){
                return new ResponseResult<>(400,"获取医生信息错误，请稍后重试",null);
            }
            /**
             * 1：排队序号
             * 2：患者id
             * 3：挂号id
             * 4：医生id
             * 5：医生姓名
             */
            //发送消息
            MqPo po = new MqPo();
            po.setOrderNum(orderNum+1);
            po.setPatientId(findbyno.getPatientId());
            po.setRegId(proofCommand.getRegId());
            po.setDoctorId(doctorRotaById.getData().getDoctorid());//医生id
            po.setDoctorName(doctorRotaById.getData().getDoctorName());//医生姓名
            proofDaoAdapter.send(po);//发送给叫号微服务
            //存入redis,挂号取票码加上挂号状态
            registerAdapter.addNoRedis(findbyno.getNo());
            return new ResponseResult<ProofCommand>(200,"取票成功",proofCommand);
        }else{
            return new ResponseResult<ProofCommand>(400,"取票失败，请稍后再试",proofCommand);
        }

    }
}
