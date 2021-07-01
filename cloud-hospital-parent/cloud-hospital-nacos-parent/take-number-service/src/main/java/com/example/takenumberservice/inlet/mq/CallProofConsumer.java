package com.example.takenumberservice.inlet.mq;

import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.outlet.client.register.pojo.QueryGetByIdVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CallProofConsumer {

    @Autowired
    private RegisterAdapter registerAdapter;

    /**
     * 监听门诊医生就诊队列的消息
     * @param msg 接收到的消息
     */
    @RabbitListener(queues = "outpatient_over_queue")//这个队列为测试的队列
    public void callProof(String msg){
        try{
            //分割字符串
            String[] split = msg.split(",");
            Long regId = Long.parseLong(split[0]);//挂号id
            String callstatus = split[1];//传过来的状态
            //获得挂号信息
            QueryGetByIdVo byRegId = registerAdapter.findByRegId(regId);
            if(byRegId == null){
                log.info("该挂号信息未查询到{},请工作人员检查",regId);
                return;
            }
            //修改挂号状态
            if (callstatus.equals("2")){//修改挂号状态为待复诊
                registerAdapter.updatebyid(regId,"6");//6待复诊
            }else if(callstatus.equals("3")){
                if(byRegId.getStatus().equals("4")){//4为已取初诊票，修改为初诊失约
                    registerAdapter.updatebyid(regId,"5");//5：初诊失约
                }else if(byRegId.getStatus().equals("7")){//7为已取复诊票，修改为复诊失约
                    registerAdapter.updatebyid(regId,"8");//8：复诊失约
                }
            }
            //删除redis
            registerAdapter.deleteNoRedis(byRegId.getNo());
            log.info("接收到的消息为{}",msg);
        }catch (Exception e){
            log.info("错误,接收到的消息{}",msg);
        }



    }
}
