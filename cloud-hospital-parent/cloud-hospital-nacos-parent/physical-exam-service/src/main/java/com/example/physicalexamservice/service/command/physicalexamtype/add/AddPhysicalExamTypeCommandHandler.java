package com.example.physicalexamservice.service.command.physicalexamtype.add;

import com.example.physicalexamservice.adapter.PhysicalExamTypeDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeVo;
import com.example.physicalexamservice.service.api.physicalexamtype.IAddPhysicalExamTypeCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IAddPhysicalExamTypeCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
public class AddPhysicalExamTypeCommandHandler implements IAddPhysicalExamTypeCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter;

    public AddPhysicalExamTypeCommandHandler(PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter) {
        this.physicalExamTypeDaoAdapter = physicalExamTypeDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public Integer action(AddPhysicalExamTypeCommand command) {
        try {
            /* 执行添加方法 */
            return physicalExamTypeDaoAdapter.add(command.getName(), command.getDescription(), PhysicalExamTypeVo.STATUS_NORMAL);
        } catch (NullPointerException e) {
            /* 捕获到 NullPointerException , 抛 PhysicalExamTypeNameRepeatedException */
            throw new PhysicalExamTypeNameRepeatedException();
        }
    }
}
