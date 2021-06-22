package com.example.workerservice.service.command.doctorrota.querybyid;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IQueryDoctorRotaByIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * 实体类 - 命令 - QueryDoctorRotaByIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
public class QueryDoctorRotaByIdCommand {

    private Long id;

    private IQueryDoctorRotaByIdCommandHandler queryDoctorRotaByIdCommandHandler;

    public QueryDoctorRotaByIdCommand() {
        this.queryDoctorRotaByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryDoctorRotaByIdCommandHandler.class);
    }

    public QueryDoctorRotaByIdCommand(Long id) {
        this();
        this.id = id;
    }

    public DoctorRotaVo execute() {
        /* 执行方法 */
        return this.queryDoctorRotaByIdCommandHandler.action(this);
    }

}
