package com.example.registerservice.inlet.subscriber;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.adapter.converter.RegisterConverter;
import com.example.registerservice.outlet.dao.es.PatientEsDao;
import com.example.registerservice.outlet.dao.es.RegisterEsDao;
import com.example.registerservice.outlet.dao.es.po.PatientEsPo;
import com.example.registerservice.outlet.dao.es.po.RegisterEsPo;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.RegisterMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.redis.PatientRedisDao;
import com.example.registerservice.outlet.dao.redis.RegisterRedisDao;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import com.example.registerservice.outlet.dao.redis.po.RegisterRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/15:19
 * @Description: 监听消息队列的类
 */
@Component
@RabbitListener(queues = "news_queue")
@Slf4j
public class VerifyNoMessage {

    private RegisterConverter registerConverter;

    private final PatientConverter patientConverter;

    private final PatientMysqlDao patientMysqlDao;

    private final PatientEsDao patientEsDao;

    private final PatientRedisDao patientRedisDao;

    private final RegisterMysqlDao registerMysqlDao;

    private final RegisterEsDao registerEsDao;

    private final RegisterRedisDao registerRedisDao;

    public VerifyNoMessage(PatientMysqlDao patientMysqlDao, PatientEsDao patientEsDao, PatientRedisDao patientRedisDao, RegisterMysqlDao registerMysqlDao, RegisterEsDao registerEsDao, RegisterRedisDao registerRedisDao, PatientConverter patientConverter, RegisterConverter registerConverter) {
        this.patientMysqlDao = patientMysqlDao;
        this.patientEsDao = patientEsDao;
        this.patientRedisDao = patientRedisDao;
        this.registerMysqlDao = registerMysqlDao;
        this.registerEsDao = registerEsDao;
        this.registerRedisDao = registerRedisDao;
        this.patientConverter = patientConverter;
        this.registerConverter = registerConverter;
    }


    @RabbitHandler
    public void process(String message) {
        log.debug("收到队列news_queue消息{}", message);
        String[] str = message.split("-");
        if (str[0].equals("h_patient")) {
            PatientMysqlPo po = patientMysqlDao.selectByPrimaryKey(Long.valueOf(str[2]));
            if (str[1].equals("redis")) {
                PatientRedisPo redisPo = patientConverter.redisConverter(po);
                patientRedisDao.save(redisPo);
                log.debug("添加patientRedisDao成功");
            } else if (str[1].equals("es")) {
                PatientEsPo esPo = patientConverter.esConverter(po);
                patientEsDao.save(esPo);
                log.debug("添加patientEsDao成功");
            }
        } else if (str[0].equals("h_register")) {
            RegisterMysqlPo po = registerMysqlDao.selectByPrimaryKey(Long.valueOf(str[2]));
            if (str[1].equals("redis")) {
                RegisterRedisPo redisPo = registerConverter.redisConverter(po);
                registerRedisDao.save(redisPo);
                log.debug("添加patientRedisDao成功");
            } else if (str[2].equals("es")) {
                RegisterEsPo esPo = registerConverter.esConverter(po);
                registerEsDao.save(esPo);
                log.debug("添加patientEsDao成功");
            }
        }
    }

}
