package com.example.workerservice.service.command.doctorrota.querylistbyidlist;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IQueryDoctorRotaListByIdListCommandHandler;
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
public class QueryDoctorRotaListByIdListCommand {

    private List<Long> idList;

    private IQueryDoctorRotaListByIdListCommandHandler queryDoctorRotaByIdCommandHandler;

    public QueryDoctorRotaListByIdListCommand() {
        this.queryDoctorRotaByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryDoctorRotaListByIdListCommandHandler.class);
    }

    public QueryDoctorRotaListByIdListCommand(List<Long> idList) {
        this();
        this.idList = idList;
    }

    public List<DoctorRotaVo> execute() {
        /* 执行方法 */
        return this.queryDoctorRotaByIdCommandHandler.action(this);
    }

}
