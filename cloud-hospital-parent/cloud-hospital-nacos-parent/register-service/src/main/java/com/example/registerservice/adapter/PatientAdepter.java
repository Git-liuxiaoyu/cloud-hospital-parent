package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.adapter.converter.PatientServicePoConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.dao.es.PatientEsDao;
import com.example.registerservice.outlet.dao.es.po.PatientEsPo;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import com.example.registerservice.outlet.dao.redis.PatientRedisDao;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import com.example.registerservice.service.command.addmessage.AddMessageCommand;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdentityIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:49
 * @Description:
 */
@Component
@Slf4j
public class PatientAdepter {

    @Autowired
    private PatientMysqlDao mysqlDao;

    @Autowired
    private PatientServicePoConverter converter;

    @Autowired
    private PatientConverter patientConverter;

    @Autowired
    private PatientRedisDao redisDao;

    @Autowired
    private PatientEsDao esDao;


    /**
     * 添加患者信息
     *
     * @param command
     * @return
     */
    public Long insert(AddPatientCommand command) {
        PatientMysqlPo converter = this.converter.converter(command);
        int insert = mysqlDao.insert(converter);
        if (insert == 0) {
            throw new AdapterException();//sql添加失败抛出异常
        }
        return converter.getId();
    }

    /**
     * 根据患者id查询患者信息
     *
     * @param command
     * @return
     */
    public Patient selectGetPatientById(QueryPatientByIdCommand command) {
        PatientRedisPo redisPo = null;
        PatientEsPo esPo = null;
        PatientMysqlPo mysqlPo = null;
        Patient patient = null;
        try {
            /*先去redis查询 ,如果查询的数据是null*/
            redisPo = redisDao.findById(command.getId()).orElseThrow(NullPointerException::new);
            /*如果没有抛异常说明查到数据,就进行对象转换*/
            patient = patientConverter.converter(redisPo);
            log.debug("根据id{}查询redis的数据{}", command.getId(), patient);
        } catch (NullPointerException e) {
            try {
                log.debug("根据id{}查询redis没有查到数据", command.getId());
                /*如果redis没有查询到就去es去查询*/
                esPo = esDao.findById(command.getId()).orElseThrow(NullPointerException::new);
                /*如果没有抛异常说明查到数据,就进行对象转换*/
                patient = patientConverter.converter(esPo);
                /*在es查询到了数据,redis既然没有的话,就在去存redis*/
                AddMessageCommand addMessageCommand = new AddMessageCommand
                        ("news_exchange", "news.add", "h_patient-redis-" + command.getId());
                /*执行添加消息表*/
                addMessageCommand.execute();
                log.debug("添加信息表成功，消息为{}","h_patient-redis-" + command.getId());
                log.debug("根据id{}查询es的数据{}", command.getId(), patient);
            } catch (NullPointerException nullPointerException) {
                log.debug("根据id{}查询es没有查到数据", command.getId());
                /*如果es没有查询到就去mysql去查询*/
                mysqlPo = mysqlDao.selectByPrimaryKey(command.getId());
                /*如果查询到mysql都是null就直接抛异常*/
                if (mysqlPo == null) {
                    log.debug("根据id{}查询Mysql没有查到数据", command.getId());
                    throw new NullPointerException();
                }
                log.debug("根据id{}查询mysql的数据{}", command.getId(), patient);
                /*在mysql查询到了数据,es,和redis既然没有的话,就在去存es和redis*/
                AddMessageCommand addMessageCommand = new AddMessageCommand
                        ("news_exchange", "news.add", "h_patient-mysql-" + command.getId());
                /*执行添加消息表*/
                addMessageCommand.execute();
                log.debug("添加信息表成功，消息为{}","mysql-" + command.getId());
                /*如果没有抛异常说明查到数据,就进行对象转换*/
                patient = patientConverter.converter(mysqlPo);
            }
        }
        /*返回转换的对象*/
        return patient;
    }

    /**
     * 根据患者身份证查询患者信息
     *
     * @param command
     * @return
     */
    public Patient selectGetPatientByIdentityId(QueryPatientByIdentityIdCommand command) {
        PatientMysqlPoExample example = new PatientMysqlPoExample();
        example.createCriteria().andIdentityidEqualTo(command.getIdentityId());
        List<PatientMysqlPo> patientMysqlPos = mysqlDao.selectByExample(example);
        //判断一下patientMysqlPos是不是空
        if (!patientMysqlPos.isEmpty()) {
            Patient converter = patientConverter.converter(patientMysqlPos.get(0));
            log.debug("根据身份证{}查询到该患者信息{}", command.getIdentityId(), converter);
            return converter;
        } else {
            log.debug("根据身份证{}没有查询到该患者信息", command.getIdentityId());
            throw new NullPointerException();
        }
    }


    /**
     * 事务对象转换为mysql对象
     *
     * @param command
     * @return
     */
    public void update(UpdatePatientCommand command) {
        PatientMysqlPoExample example = new PatientMysqlPoExample();
        PatientMysqlPo converter = patientConverter.converter(command);
        example.createCriteria().andIdEqualTo(command.getId());
        int i = mysqlDao.updateByExampleSelective(converter, example);
        if (i == 0) {
            throw new AdapterException();
        }
    }
}
