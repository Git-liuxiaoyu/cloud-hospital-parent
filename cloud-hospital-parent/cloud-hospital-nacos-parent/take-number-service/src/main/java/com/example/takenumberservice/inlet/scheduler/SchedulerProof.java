package com.example.takenumberservice.inlet.scheduler;


import com.example.takenumberservice.outlet.dao.mysql.MassageDao;
import com.example.takenumberservice.outlet.dao.mysql.PharmacyProofDao;
import com.example.takenumberservice.outlet.dao.mysql.Proofdao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.MassagePo;
import com.example.takenumberservice.outlet.mq.SendMsg;
import com.example.takenumberservice.util.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时任务
 */
@Component
@Slf4j
public class SchedulerProof {

    @Autowired
    private Email email;

    @Autowired
    private Proofdao proofDao;

    @Autowired
    private PharmacyProofDao pharmacyProofDao;

    @Autowired
    private MassageDao massageDao;

    @Autowired
    private SendMsg sendMsg;

    /**
     * 定时删除整张取票凭证表
     */
    @Scheduled(cron="0 0 0 * * ?")//每天0点执行一次
    public void deleTable(){
        proofDao.delete();//挂号
        pharmacyProofDao.delete();//药房
        log.info("24点，删除整表,并删除状态为1的消息表");
        massageDao.dele();//消息
    }


    /**
     * 查询消息表并重新发送消息
     */
    @Scheduled(cron="*/6 * * * * ?")//每6秒执行一次
    public void retry(){
        List<MassagePo> findbystatus = massageDao.findbystatus();
        if(findbystatus !=null){//如果查询到发送失败的消息重新发送并修改期发送次数的值
            for (MassagePo massagePo : findbystatus) {
                if(massagePo.getRetry_count() <=0){
                    //重试次数超过6次，发送邮件请工作人员,并更改状态为3（无法解决的消息）
                    massagePo.setStatus("3");
                    //重新发送消息，并将改变数据的消息存入数据库
                    int i = massageDao.updateMessage(massagePo);
                    if(i>0){
                        sendMsg.SendRetry(massagePo);
                        //发送邮件给工作人员
                        String staff = email.staff();
                        log.info("发送邮件{}",staff);
                    }else{
                        log.info("状态未修改成功");
                    }
                    return;
                }
                int cont = massagePo.getRetry_count()-1;
                massagePo.setRetry_count(cont);
                //重新发送消息，并将改变数据的消息存入数据库
                sendMsg.SendRetry(massagePo);
                int i = massageDao.updateMessagecont(massagePo);
                if(i>0){
                    log.info("重新发送，次数还剩：{}",massagePo.getRetry_count());
                }

            }
        }


    }




}
