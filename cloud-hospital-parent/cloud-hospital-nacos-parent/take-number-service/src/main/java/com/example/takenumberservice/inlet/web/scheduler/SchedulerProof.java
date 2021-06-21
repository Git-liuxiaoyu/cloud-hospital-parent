package com.example.takenumberservice.inlet.web.scheduler;


import com.example.takenumberservice.outlet.dao.mysql.ProofDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
@Slf4j
public class SchedulerProof {

    @Autowired
    private ProofDao proofDao;

    /**
     * 定时删除整张取票凭证表
     */
    @Scheduled(cron="0 0 0 * * ?")//每天0点执行一次
    public void deleTable(){
        proofDao.delete();
        log.info("24点，删除整表");
    }



}
