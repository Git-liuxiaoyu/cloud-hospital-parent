package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.RegisterVoConverter;
import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.outlet.dao.mysql.RegisterMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPoExample;
import com.example.registerservice.outlet.dao.redis.PatientRedisDao;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import com.example.registerservice.service.command.addphone.PushPhoneGoQueueCommand;
import com.example.registerservice.service.query.queryphoneandcode.QueryPhoneAndCodeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
public class RegisterAdapter {

    @Autowired
    private RegisterMysqlDao mysqlDao;

    @Autowired
    private PatientRedisDao redisDao;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RegisterVoConverter converter;

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

    public RegisterVo getByNo(String no){
        RegisterMysqlPoExample example=new RegisterMysqlPoExample();
        example.createCriteria().andNoEqualTo(no);
        List<RegisterMysqlPo> mysqlPoList = mysqlDao.selectByExample(example);
        RegisterVo convert = converter.convert(mysqlPoList.get(0));
        return convert;
    }
}
