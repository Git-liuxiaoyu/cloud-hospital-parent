package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.RegisterConverter;
import com.example.registerservice.adapter.converter.RegisterServiceConverter;
import com.example.registerservice.adapter.converter.RegisterVoConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.client.po.DoctorRotaClientPo;
import com.example.registerservice.outlet.client.worker.IWorkerServiceClient;
import com.example.registerservice.outlet.dao.mysql.RegisterMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPoExample;
import com.example.registerservice.outlet.dao.mysql.po.RegisterOrderMysqlPo;
import com.example.registerservice.outlet.dao.redis.PhoneRedisDao;
import com.example.registerservice.outlet.dao.redis.po.PhoneRedisPo;
import com.example.registerservice.service.command.addRegister.AddRegisterCommand;
import com.example.registerservice.service.command.addphone.AddPhoneGoQueueCommand;
import com.example.registerservice.service.command.updateregister.UpdateRegisterCommand;
import com.example.registerservice.service.query.queryphoneandcode.QueryPhoneAndCodeCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterByIdCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterByPhoneCommand;
import com.example.registerservice.service.query.queryregister.po.Register;
import com.example.registerservice.service.query.queryregister.po.RegisterServicePo;
import com.example.registerservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ??????
 * @Date: 2021/06/17/8:04
 * @Description:
 */
@Component
@Slf4j
public class RegisterAdapter {

    @Autowired
    private RegisterMysqlDao mysqlDao;

    @Autowired
    private PhoneRedisDao redisDao;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RegisterVoConverter converter;


    @Autowired
    private RegisterServiceConverter serviceConverter;

    @Autowired
    private IWorkerServiceClient client;

    @Autowired
    private RegisterConverter registerConverter;


    /**
     * ??????????????????redis
     *
     * @param command
     */
    public void addPhoneGoRedis(AddPhoneGoQueueCommand command) {
        PhoneRedisPo redisPo = new PhoneRedisPo(command.getPhone());
        redisDao.save(redisPo);
    }

    /**
     * ?????????????????????redis????????????????????????
     *
     * @param command
     * @return
     */
    public PhoneRedisPo select(AddPhoneGoQueueCommand command) {
        Optional<PhoneRedisPo> redisPo = redisDao.findById(command.getPhone());
        return redisPo.orElseThrow(NullPointerException::new);
    }

    /**
     * ???????????????????????????????????????????????????
     *
     * @param command
     * @return
     */
    public String select(QueryPhoneAndCodeCommand command) {
        String s = template.boundValueOps("Login-" + command.getPhone()).get();
        if (!StringUtils.isEmpty(s)) {
            return s;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param no
     * @return
     */
    public Register.ByNo getByNo(String no) {
        Register.ByNo convert = null;
        RegisterMysqlPoExample example = new RegisterMysqlPoExample();
        example.createCriteria().andNoEqualTo(no);
        List<RegisterMysqlPo> mysqlPoList = mysqlDao.selectByExample(example);
        //?????????null?????????????????????????????????
        if (!mysqlPoList.isEmpty()) {
            convert = converter.convert(mysqlPoList.get(0));
        } else {
            throw new NullPointerException();
        }
        return convert;
    }

    /**
     * ??????id?????????????????????
     *
     * @param command
     */
    public void update(UpdateRegisterCommand command) {
        RegisterMysqlPo po = new RegisterMysqlPo();
        po.setId(command.getId());
        po.setStatus(command.getStatus());
        int i = mysqlDao.updateByPrimaryKeySelective(po);
        //??????????????????????????????
        if (i == 0) {
            throw new AdapterException();
        }
    }

    /**
     * ??????????????????
     *
     * @param command
     */
    public void insert(AddRegisterCommand command) {
        int i = mysqlDao.insertSelective(serviceConverter.converter(command));
        //??????????????????????????????
        if (i == 0) {
            throw new AdapterException();
        }
        log.info("{}?????????????????????????????????", command.getPhone());
    }

    /**
     * ?????????????????????????????????
     *
     * @param command
     */
    public List<RegisterServicePo> select(QueryRegisterByPhoneCommand command) {
        List<RegisterOrderMysqlPo> all = mysqlDao.findAll(command.getPhone());

        if(all.isEmpty()){
           throw new AdapterException();
        }

        List<RegisterServicePo> converter = serviceConverter.converter(all);
        //?????????????????????????????????id
        List<String> rotaIdList = new ArrayList<>();
        //????????????rotaIdList??????????????????????????????
        converter.forEach(item -> rotaIdList.add(item.getRotaId()));
        ResponseResult<List<DoctorRotaClientPo>> doctorRotaByRotaIdList = client.findDoctorRotaListByIdList(rotaIdList);
        List<DoctorRotaClientPo> data = doctorRotaByRotaIdList.getData();

        converter.forEach(item -> data.forEach(item2 -> {
            if (item.getRotaId().equals("" + item2.getId())) {
                item.setDoctorName(item2.getDoctorName());
                item.setDepartmentName(item2.getDepartmentname());
            }
        }));
        return converter;
    }

    /**
     * ????????????id????????????????????????
     *
     * @param command
     * @return
     */
    public Register.ById selectById(QueryRegisterByIdCommand command) {
        RegisterMysqlPo registerMysqlPo = mysqlDao.selectByPrimaryKey(command.getId());
        if (registerMysqlPo == null) {
            throw new NullPointerException();
        }
        Register.ById converter = registerConverter.converter(registerMysqlPo);
        return converter;
    }
}
