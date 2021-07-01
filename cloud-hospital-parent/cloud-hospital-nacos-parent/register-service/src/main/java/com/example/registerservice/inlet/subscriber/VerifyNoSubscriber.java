package com.example.registerservice.inlet.subscriber;

import com.example.registerservice.service.command.updateregister.UpdateRegisterCommand;
import com.example.registerservice.service.query.queryregister.QueryRegisterGetByNoCommand;
import com.example.registerservice.service.query.queryregister.po.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/20:56
 * @Description: 监听挂号的死信队列
 */
@Component
@RabbitListener(queues = "register_order_dlq")
@Slf4j
public class VerifyNoSubscriber {

    @RabbitHandler
    public void process(String message) {
        log.info("死信队列拿到挂号No为{}", message);
        Register.ByNo register = getStatusByNo(message);
        if (register.getStatus() != null && register.getStatus().equals("0")) {
            updateStatus(register.getId(), "2");//将状态改为2表示15分钟没有付款
            log.debug("修改{}的状态成功", register.getStatus());
        }

    }

    /**
     * 根据no查询挂号的状态
     *
     * @param no
     * @return
     */
    public Register.ByNo getStatusByNo(String no) {
        return new QueryRegisterGetByNoCommand(no).execute();
    }

    public void updateStatus(Long id, String status) {
        new UpdateRegisterCommand(id, status).execute();
    }
}
