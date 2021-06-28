package com.example.drugservice.inlet.subscriber;

import com.example.drugservice.outlet.dao.mysql.MessageDao;
import com.example.drugservice.outlet.dao.mysql.ReceivedDao;
import com.example.drugservice.outlet.dao.mysql.po.MessagePo;
import com.example.drugservice.outlet.dao.mysql.po.ReceivedPo;
import com.example.drugservice.outlet.dao.redis.DrugOddRedisDao;
import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@Component
@RabbitListener(queues = "zhang")
@Transactional
public class DrugOddUpdateMessageSubscriber {

    @Autowired
    private ReceivedDao receivedMessageDao;

    @Autowired
    private DrugOddRedisDao redisDao;

    @Autowired
    private MessageDao messageDao;

    @RabbitHandler
    public void handle(String message
                    , Channel channel
                    , @Header(AmqpHeaders.DELIVERY_TAG)long tag)  {

        log.info("Receiver : {}", message);
        String messageId= message.split(":")[0];
        String messageContent= message.split(":")[1];
        //1.判断是否是重复消息
        try {
            receivedMessageDao.insert(new ReceivedPo(messageId));
            log.info("添加id为[{}]到去重表成功",messageId);
        }catch (RuntimeException e){
            log.info("这是一条重复消息");
            basicRejectQuietly(channel,tag,false);
            //修改消息状态
            //如果不是一个微服务通过openfen 修改消息状态  状态为已消费
            MessagePo messagePo = new MessagePo();
            messagePo.setId(Long.parseLong(messageId));
            messagePo.setStatus(MessagePo.MESSAGE_STATE_CONSUMED);
            messageDao.updateByPrimaryKeySelective(messagePo);
            return;
        }
        log.info("这是一条新消息");
        try{
            //2执行业务
            redisDao.deleteById(Long.parseLong(messageContent));
            log.info("执行业务操作 删除redis为[{}]的数据",messageContent);
            //回复消息,已收到
            basicAckQuietly(channel,tag,false);
            //修改消息状态
            //如果不是一个微服务通过openfen 修改消息状态  状态为已消费
            MessagePo messagePo = new MessagePo();
            messagePo.setId(Long.parseLong(messageId));
            messagePo.setStatus(MessagePo.MESSAGE_STATE_CONSUMED);
            messageDao.updateByPrimaryKeySelective(messagePo);
            log.info("修改消息[{}]的状态为已消费",messageId);
        }catch (Exception e){
            e.printStackTrace();
            log.info("如果执行本地业务失败,拒绝消息,且不重新入队");
            log.info("等待可靠消息服务的定时任务重新发送消息,再次执行业务");
            basicRejectQuietly(channel,tag,true);
            throw  new RuntimeException(e);
        }

    }
    public static void basicRejectQuietly(Channel channel,long deliveryTag,boolean requeue){
        try{
            channel.basicReject(deliveryTag,requeue);
        }catch (Exception e){
           throw  new RuntimeException(e);
        }
    }

    public static void basicAckQuietly(Channel channel,long deliveryTag,boolean multiple){
        try{
            channel.basicAck(deliveryTag,multiple);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

}
