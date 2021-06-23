package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.RegisterConverter;
import com.example.registerservice.adapter.converter.RegisterServiceConverter;
import com.example.registerservice.adapter.converter.RegisterVoConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.outlet.client.po.DoctorRotaClientPo;
import com.example.registerservice.outlet.client.worker.IWorkerServiceClient;
import com.example.registerservice.outlet.dao.mysql.RegisterMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPoExample;
import com.example.registerservice.outlet.dao.mysql.po.RegisterOrderMysqlPo;
import com.example.registerservice.outlet.dao.redis.PatientRedisDao;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import com.example.registerservice.service.command.addRegister.AddRegisterCommand;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;
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
 * @Auther: 小刘
 * @Date: 2021/06/17/8:04
 * @Description:
 */
@Component
@Slf4j
public class RegisterAdapter {

    @Autowired
    private RegisterMysqlDao mysqlDao;

    @Autowired
    private PatientRedisDao redisDao;

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
     * 添加手机号到redis
     *
     * @param command
     */
    public void addPhoneGoRedis(PushPhoneGoQueueCommand command) {
        PatientRedisPo redisPo = new PatientRedisPo(command.getPhone());
        redisDao.save(redisPo);
    }

    /**
     * 根据手机号查询redis是否存在该手机号
     *
     * @param command
     * @return
     */
    public PatientRedisPo select(PushPhoneGoQueueCommand command) {
        Optional<PatientRedisPo> redisPo = redisDao.findById(command.getPhone());
        return redisPo.orElseThrow(NullPointerException::new);
    }

    /**
     * 根据手机号和验证码查询是否有该对象
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
     * 根据挂号编号查询该号码的信息
     *
     * @param no
     * @return
     */
    public RegisterVo getByNo(String no) {
        RegisterVo convert = null;
        RegisterMysqlPoExample example = new RegisterMysqlPoExample();
        example.createCriteria().andNoEqualTo(no);
        List<RegisterMysqlPo> mysqlPoList = mysqlDao.selectByExample(example);
        //如果是null会抛异常，这里判断一下
        if (!mysqlPoList.isEmpty()) {
            convert = converter.convert(mysqlPoList.get(0));
        } else {
            throw new NullPointerException();
        }
        return convert;
    }

    /**
     * 根据id修改挂号的状态
     *
     * @param command
     */
    public void update(UpdateRegisterCommand command) {
        RegisterMysqlPo po = new RegisterMysqlPo();
        po.setId(command.getId());
        po.setStatus(command.getStatus());
        int i = mysqlDao.updateByPrimaryKeySelective(po);
        //如果修改不成功抛异常
        if (i == 0) {
            throw new AdapterException();
        }
    }

    /**
     * 添加挂号信息
     *
     * @param command
     */
    public void insert(AddRegisterCommand command) {
        int i = mysqlDao.insertSelective(serviceConverter.converter(command));
        //如果修改不成功抛异常
        if (i == 0) {
            throw new AdapterException();
        }
        log.info("{}号新增一条挂号记录成功", command.getPhone());
    }

    /**
     * 根据手机号查询挂号列表
     *
     * @param command
     */
    public List<RegisterServicePo> select(QueryRegisterByPhoneCommand command) {
        List<RegisterOrderMysqlPo> all = mysqlDao.findAll(command.getPhone());
        List<RegisterServicePo> converter = serviceConverter.converter(all);
        //所有挂号订单所有的排班id
        List<String> rotaIdList = new ArrayList<>();
        //根据排班rotaIdList查询医生和科目的名称
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
     * 根据挂号id查询挂号详细信息
     *
     * @param command
     * @return
     */
    public Register selectById(QueryRegisterByIdCommand command) {
        RegisterMysqlPo registerMysqlPo = mysqlDao.selectByPrimaryKey(command.getId());
        if (registerMysqlPo == null) {
            throw new NullPointerException();
        }
        Register converter = registerConverter.converter(registerMysqlPo);
        return converter;
    }
}
