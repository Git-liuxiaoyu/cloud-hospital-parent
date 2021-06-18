package com.example.takenumberservice.service.command.addProof;

import com.example.takenumberservice.adapter.ProofDaoAdapter;
import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
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
        if(findbyno.getVisitSection() == '1'){//如果就诊时间段为上午
            String amend = "12:00:00";
            String amstart = "09:00:00";
            Integer i=thistime.compareTo(amend);//如果是正数则代表当前系统时间大于上午12点,不让取票
            Integer k=amstart.compareTo(thistime);//如果是正数则代表当前系统时间小于上午9点，不让取票
            if(i>0){
                return new ResponseResult<>(400,"上午取票时间已过，请重新挂号",null);
            }else if(k>0){
                return new ResponseResult<>(400,"上午还未到取票时间，请稍后重试",null);
            }
        }else{//反之，就诊时间段为下午
            String pmstart = "14:00:00";
            String pmend = "18:00:00";
            Integer i=thistime.compareTo(pmend);//如果是正数则代表当前系统时间大于下午12点,不让取票
            Integer k=pmstart.compareTo(thistime);//如果是正数则代表当前系统时间小于下午14点，不让取票
            if(i>0){
                return new ResponseResult<>(400,"下午取票时间已过，请重新挂号",null);
            }else if(k>0){
                return new ResponseResult<>(400,"下午还未到取票时间，请稍后重试",null);
            }
        }


        //往取票表里存数据,service 调service
        ProofCommand proofCommand = new ProofCommand();
        String findbyroomid = proofDaoAdapter.findbyroomid(findbyno.getRoomId());//根据房间id查询房间名

        proofCommand.setNo(findbyno.getNo());//挂号码
        proofCommand.setRegId(findbyno.getId());//挂号id
        proofCommand.setDepartmentId(findbyno.getDepartmentId());//科室id
        proofCommand.setRoomName(findbyroomid);//房间名
        Integer orderNum = proofDaoAdapter.findorderNum();//最新的排队序号
        //Integer orderNum = null;
        if(orderNum == null){
            orderNum = 0;
        }
        proofCommand.setOrderNum(orderNum+1);
        proofCommand.setCreateTime(thistime);
        if(findbyno.getStatus() == 3 || findbyno.getStatus() == 5){
            proofCommand.setStatus('1');//设置取票状态为初诊票
            //修改挂号状态为待初诊
            registerAdapter.updatebyid(findbyno.getId(),4);
        }else if(findbyno.getStatus() == 6 || findbyno.getStatus() == 7){
            proofCommand.setStatus('2');//设置取票状态为复诊票
        }

        return new ResponseResult<ProofCommand>(200,"取票成功",proofCommand);
    }
}
