package com.example.physicalexamservice.inlet.subscriber;

import com.example.physicalexamservice.config.mq.RabbitMQConfig;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.mysql.*;
import com.example.physicalexamservice.outlet.dao.mysql.po.*;
import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordEsEventPublisher;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
@Component
@Slf4j
public class PhysicalExamRecordIsPaySubscriber {


    /* 构造注入 - 开始 */
    private final MessageMysqlPoDao messageMysqlPoDao;
    private final ReceivedMysqlPoDao receivedMysqlPoDao;
    private final PhysicalExamMysqlPoDao physicalExamMysqlPoDao;
    private final PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao;
    private final PhysicalExamRecordDetailMysqlPoDao physicalExamRecordDetailMysqlPoDao;


    public PhysicalExamRecordIsPaySubscriber(MessageMysqlPoDao messageMysqlPoDao, ReceivedMysqlPoDao receivedMysqlPoDao, PhysicalExamMysqlPoDao physicalExamMysqlPoDao, PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao, PhysicalExamRecordDetailMysqlPoDao physicalExamRecordDetailMysqlPoDao) {
        this.messageMysqlPoDao = messageMysqlPoDao;
        this.receivedMysqlPoDao = receivedMysqlPoDao;
        this.physicalExamMysqlPoDao = physicalExamMysqlPoDao;
        this.physicalExamRecordMysqlPoDao = physicalExamRecordMysqlPoDao;
        this.physicalExamRecordDetailMysqlPoDao = physicalExamRecordDetailMysqlPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 监听 - 队列 - division_es_q
     */
    @RabbitListener(queues = "physical_exam_record_is_pay_real_q")
    @Transactional
    public void PhysicalExamRecordEsQueueSubscriber(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        /* 获取消息ID */
        long msgId = Long.parseLong(message.getMessageProperties().getHeaders().get("spring_returned_message_correlation").toString());
        MessageMysqlPo messagePo = messageMysqlPoDao.selectByPrimaryKey(msgId);
        /* 判断是否为null */
        if (messagePo == null) {
            log.debug("没有找到主键ID为 [{}] 的数据库信息", msgId);
            return;
        }
        /* 实例化 */
        MessageMysqlPoExample messagePoExample = new MessageMysqlPoExample();
        /* 编写条件 Version 和 Id 相等 */
        messagePoExample.createCriteria().andIdEqualTo(msgId).andVersionEqualTo(messagePo.getVersion());
        try {
            /* 存入去重表 */
            receivedMysqlPoDao.insert(new ReceivedMysqlPo(String.valueOf(msgId)));
            log.debug("添加 msgId -> {} 到去重表成功", msgId);
        } catch (RuntimeException e) {
            log.debug("添加 msgId -> {} 到去重表失败 , 该消息为重复消息", msgId);
            RabbitMQConfig.basicRejectQuietly(channel, tag, false);
            return;
        }

        try {

            /* 获得消息主体并分割为数组 */
            String[] judgeArr = new String(message.getBody()).split("-");
            /* 判断是何命令 */
            if (judgeArr[0].equals("ISPAY")) {
                handlePhysicalExamRecordIsPay(Long.parseLong(judgeArr[1]));
            } else {
                log.info("Subscriber_Physical_Exam_Record_Is_Pay 无匹配处理方法 {} -> {}", judgeArr[0], judgeArr[1]);
            }

            /* 修改消息状态 */
            /* 赋值 */
            messagePo.setVersion(messagePo.getVersion() + 1);
            /* 状态改为已消费 */
            messagePo.setStatus(MessageMysqlPo.COMSUME_SUCCESS);
            messageMysqlPoDao.updateByExampleSelective(messagePo, messagePoExample);
            /* 应答消息 , 已收到 */
            RabbitMQConfig.basicAckQuietly(channel, tag, false);
        } catch (RuntimeException e) {
            e.printStackTrace();
            log.error("本地业务执行失败 , 失败原因 -> [{}] , 失败消息 —> [{}] , 下面判断是否需要不再重新发送", e.getCause(), e.getMessage());
            /* 判断重试次数是否为0 */
            if (messagePo.getRetryCount() <= 0) {
                log.debug("消息未能在消费端重新消费 , 并且不再重新发送");
                /* 填值 */
                messagePo.setVersion(messagePo.getVersion() + 1); /* 修改版本号 */
                messagePo.setStatus(MessageMysqlPo.COMSUME_FAIL); /* 切换状态 - 消费失败 */
                /* 调用方法更新 */
                messageMysqlPoDao.updateByExampleSelective(messagePo, messagePoExample);
                /* 后续不需要进行了,所以也不会抛异常以回滚去重表,进入摇人阶段,应答但不重新进入队列 */
                RabbitMQConfig.basicRejectQuietly(channel, tag, false);
                return;
            } else {
                log.info("等待可靠消息服务的定时任务重新发送消息 , 再次执行业务");
            }
            /* 不正常应答 */
            RabbitMQConfig.basicRejectQuietly(channel, tag, false);

            /* 抛出异常回滚去重表 */
            throw new RuntimeException(e);
        }


    }

    /**
     * @param id
     */
    private void handlePhysicalExamRecordIsPay(Long id) {
        try {
            /* 1.先查 */
            PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = physicalExamRecordMysqlPoDao.selectByPrimaryKey(id);
            /* 判断是否为 null */
            if (physicalExamRecordMysqlPo == null) {
                throw new NullPointerException();
            }
            /* LOG */
            log.info("找到 PhysicalExamRecordMysqlPo [{}]", physicalExamRecordMysqlPo);
            /* 判断是否支付 */
            if (!physicalExamRecordMysqlPo.getStatus().equals(PhysicalExamRecordVo.STATUS_PAYED)) {
                /* 修改体检单状态为已关闭 */
                physicalExamRecordMysqlPo.setStatus(PhysicalExamRecordVo.STATUS_CLOSE);
                /* 修改MySQL */
                physicalExamRecordMysqlPoDao.updateByPrimaryKeySelective(physicalExamRecordMysqlPo);
                /* 如果未支付,退回其下所有的体检详情的体检次数 */
                handlePhysicalExamRecordDetailNotPay(id);
                /* Event Bus 修改体检单 EsPo 状态 */
                ApplicationContextHolder.getApplicationContext().publishEvent(new IPhysicalExamRecordEsEventPublisher.UpdateStatusPhysicalExamRecordEsEvent(physicalExamRecordMysqlPo));
            }
        } catch (NullPointerException e) {
            log.info("没有在 MySQL 找到ID为 [{}] 的 PhysicalExamRecord", id);
            throw new RuntimeException();
        }
    }

    /**
     * 处理没付款的情况
     *
     * @param recordId
     */
    private void handlePhysicalExamRecordDetailNotPay(Long recordId) {
        /* 查找没付款的体检项目详情 */
        /* 实例化 PhysicalExamRecordDetailMysqlPoExample */
        PhysicalExamRecordDetailMysqlPoExample physicalExamRecordDetailMysqlPoExample = new PhysicalExamRecordDetailMysqlPoExample();
        physicalExamRecordDetailMysqlPoExample.createCriteria().andRecordidEqualTo(recordId);
        /* 调用方法查找 */
        List<PhysicalExamRecordDetailMysqlPo> physicalExamRecordDetailMysqlPos = physicalExamRecordDetailMysqlPoDao.selectByExample(physicalExamRecordDetailMysqlPoExample);
        /* 循环集合 */
        physicalExamRecordDetailMysqlPos.forEach(physicalExamRecordDetailMysqlPo -> {
            /* 找到每个体检项目 */
            PhysicalExamMysqlPo physicalExamMysqlPo = physicalExamMysqlPoDao.selectByPrimaryKey(physicalExamRecordDetailMysqlPo.getExamid());
            /* 判断是否为null */
            if (physicalExamMysqlPo == null) {
                return;
            }
            /* 如果不为null */
            /* 修改库存 */
            Long newLeftSotck = physicalExamMysqlPo.getLeftstock() + physicalExamRecordDetailMysqlPo.getCount();
            physicalExamMysqlPo.setLeftstock(newLeftSotck);
            physicalExamMysqlPoDao.updateByPrimaryKeySelective(physicalExamMysqlPo);
            /* 存到Msg表 */
            MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
            messageMysqlPo.setMessageContent("UPDATE-" + physicalExamMysqlPo.getId());
            messageMysqlPo.setExchange("physical_exam_es_ex");
            messageMysqlPo.setRoutingKey("physical.exam.es");
            messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
            messageMysqlPoDao.insertSelective(messageMysqlPo);
        });

    }

}
