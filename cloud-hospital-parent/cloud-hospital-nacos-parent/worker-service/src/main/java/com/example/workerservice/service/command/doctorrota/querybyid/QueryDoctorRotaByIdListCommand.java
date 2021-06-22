package com.example.workerservice.service.command.doctorrota.querybyid;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IQueryDoctorRotaByIdListCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.util.List;

/**
 * 实体类 - 命令 - QueryDoctorRotaByIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
public class QueryDoctorRotaByIdListCommand {

    private List<Long> idList;

    private IQueryDoctorRotaByIdListCommandHandler queryDoctorRotaByIdCommandHandler;

    public QueryDoctorRotaByIdListCommand() {
        this.queryDoctorRotaByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryDoctorRotaByIdListCommandHandler.class);
    }

    public QueryDoctorRotaByIdListCommand(List<Long> idList) {
        this();
        this.idList = idList;
    }

    public List<DoctorRotaVo> execute() {
        /* 执行方法 */
        return this.queryDoctorRotaByIdCommandHandler.action(this);
    }

}
