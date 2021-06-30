package com.example.workerservice.inlet.subscriber;

import com.example.workerservice.config.mq.RabbitMQConfig;
import com.example.workerservice.outlet.dao.mysql.DivisionPoDao;
import com.example.workerservice.outlet.dao.mysql.MessagePoDao;
import com.example.workerservice.outlet.dao.mysql.ReceivedPoDao;
import com.example.workerservice.outlet.dao.mysql.po.DivisionPo;
import com.example.workerservice.outlet.dao.mysql.po.MessagePo;
import com.example.workerservice.outlet.dao.mysql.po.MessagePoExample;
import com.example.workerservice.outlet.dao.mysql.po.ReceivedPo;
import com.example.workerservice.outlet.dao.redis.DivisionRedisPoDao;
import com.example.workerservice.util.converter.DivisionRedisPoConverter;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订阅者类 - 订阅 -
 */
@Component
@Slf4j
public class DivisionRedisCacheMQSubscriber {

    /* 构造方法 - 开始 */
    private final DivisionRedisPoDao divisionRedisPoDao;

    private final DivisionPoDao divisionPoDao;

    private final DivisionRedisPoConverter divisionRedisPoConverter;

    private final MessagePoDao messagePoDao;

    private final ReceivedPoDao receivedPoDao;

    public DivisionRedisCacheMQSubscriber(DivisionRedisPoDao divisionRedisPoDao, DivisionPoDao divisionPoDao, DivisionRedisPoConverter divisionRedisPoConverter, MessagePoDao messagePoDao, ReceivedPoDao receivedPoDao) {
        this.divisionRedisPoDao = divisionRedisPoDao;
        this.divisionPoDao = divisionPoDao;
        this.divisionRedisPoConverter = divisionRedisPoConverter;
        this.messagePoDao = messagePoDao;
        this.receivedPoDao = receivedPoDao;
    }
    /* 构造方法 - 结束 */

    /**
     * 监听 - 队列 - division_redis_cache_q
     */
    @RabbitListener(queues = "division_redis_cache_q")
    @Transactional
    public void DivisionRedisCacheQSubscriber(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        /* 获取消息ID */
        long msgId = Long.parseLong(message.getMessageProperties().getHeaders().get("spring_returned_message_correlation").toString());
        MessagePo messagePo = messagePoDao.selectByPrimaryKey(msgId);
        /* 判断是否为null */
        if (messagePo == null) {
            log.debug("没有找到主键ID为 [{}] 的数据库信息", msgId);
            return;
        }
        /* 实例化 */
        MessagePoExample messagePoExample = new MessagePoExample();
        /* 编写条件 Version 和 Id 相等 */
        messagePoExample.createCriteria().andIdEqualTo(msgId).andVersionEqualTo(messagePo.getVersion());
        try {
            /* 存入去重表 */
            receivedPoDao.insert(new ReceivedPo(String.valueOf(msgId)));
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
            if (judgeArr[0].equals("DELETE")) {
                handleDivisionRedisDelete(Integer.parseInt(judgeArr[1]));
            } else if (judgeArr[0].equals("UPDATE")) {
                handleDivisionRedisUpdateDelete(Integer.parseInt(judgeArr[1]));
            } else {
                log.info("Subscriber_Division_Redis_Cache 无匹配处理方法 {} -> {}", judgeArr[0], judgeArr[1]);
            }
            /* 修改消息状态 */
            /* 赋值 */
            messagePo.setVersion(messagePo.getVersion() + 1);
            /* 状态改为已消费 */
            messagePo.setStatus(MessagePo.COMSUME_SUCCESS);
            messagePoDao.updateByExampleSelective(messagePo, messagePoExample);
            /* 应答消息 , 已收到 */
            RabbitMQConfig.basicAckQuietly(channel, tag, false);
        } catch (RuntimeException e) {
            e.printStackTrace();
            log.error("本地业务执行失败 , 失败原因 -> [{}] , 失败消息 —> [{}] , 下面判断是否需要不再重新发送", e.getCause(), e.getMessage());
            /* 判断重试次数是否为0 */
            if (messagePo.getRetryCount() <= 0) {
                log.debug("消息未能在消费端重新消费 , 并且不再重新发送");
                /* 填值 */
                messagePo.setVersion(messagePo.getVersion() + 1);
                messagePo.setStatus(MessagePo.COMSUME_FAIL); /* 切换状态 */
                /* 调用方法更新 */
                messagePoDao.updateByExampleSelective(messagePo, messagePoExample);
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
    private void handleDivisionRedisUpdateDelete(Integer id) {
        try {
            /* 1.先查 */
            DivisionPo divisionPo = divisionPoDao.selectByPrimaryKey(id);
            /* 判断是否为 null */
            if (divisionPo == null) {
                throw new NullPointerException();
            }
            /* LOG */
            log.info("找到 Divsion [{}]", divisionPo);
            /* 2.转为 RedisPo 并存入 */
            divisionRedisPoDao.save(divisionRedisPoConverter.convert(divisionPo));
        } catch (NullPointerException e) {
            log.info("没有在 MySQL 找到ID为 [{}] 的 Division", id);
        }

    }

    /**
     * @param id
     */
    private void handleDivisionRedisDelete(Integer id) {
        /* 直接删除 */
        /* 根据 ID 在 Redis 删除 */
        divisionRedisPoDao.deleteById(id);
    }


}