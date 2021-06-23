package com.example.physicalexamservice.inlet.web.subscriber;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordEsPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamRecordMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPoExample;
import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordEsEventPublisher;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订阅者类 - PhysicalExamRecordSubscriber
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/23
 */
@Component
@Slf4j
public class PhysicalExamRecordSubscriber {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao;

    private final PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao;

    public PhysicalExamRecordSubscriber(PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao, PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao) {
        this.physicalExamRecordMysqlPoDao = physicalExamRecordMysqlPoDao;
        this.physicalExamRecordEsPoDao = physicalExamRecordEsPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 订阅 PhysicalExamRecord - Payed 队列 (已支付)
     *
     * @param message
     */
//    @RabbitListener(queues = "physical_exam_record_payed_q")
    public void subscribePhysicalExamRecordPayed(Message message, Channel channel) {
        /* 获得编号 */
        String physicalExamRecordNo = new String(message.getBody());
        /* LOG */
        log.info("修改编号为 [{}] 的体检记录状态为 [已支付]", message.getBody());
        /* 调用方法修改 */
        /* 先查 */
        /* 实例化 PhysicalExamRecordMysqlPoExample */
        PhysicalExamRecordMysqlPoExample physicalExamRecordMysqlPoExample = new PhysicalExamRecordMysqlPoExample();
        /* 编写条件 */
        physicalExamRecordMysqlPoExample.createCriteria().andNoEqualTo(physicalExamRecordNo);
        /* 查询 */
        List<PhysicalExamRecordMysqlPo> physicalExamRecordMysqlPoList = physicalExamRecordMysqlPoDao.selectByExample(physicalExamRecordMysqlPoExample);
        /* 判断是否为空 */
        try {
            if (physicalExamRecordMysqlPoList != null && physicalExamRecordMysqlPoList.size() == 1) {
                /* 不满足要求抛异常 NullPointerException */
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            log.error("体检记录查找唯一编号 [{}] 失败", physicalExamRecordNo);
            return;
        }
        /* 不为空则更新 */
        /* 取到唯一 */
        PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = physicalExamRecordMysqlPoList.get(0);
        /* 修改状态 */
        physicalExamRecordMysqlPo.setStatus(PhysicalExamRecordVo.STATUS_PAYED);
        /* 更新到数据库 */
        physicalExamRecordMysqlPoDao.updateByPrimaryKeySelective(physicalExamRecordMysqlPo);
        /* 发送 Event Bus 修改 Es 状态 */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IPhysicalExamRecordEsEventPublisher.UpdateStatusPhysicalExamRecordEsEvent(physicalExamRecordMysqlPo));
    }

}
