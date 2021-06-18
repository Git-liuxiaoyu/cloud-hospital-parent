package com.example.registerservice.service.query.querysubjecttype;

import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.api.IQuerySubjectCommandHandler;
import com.example.registerservice.service.api.IQuerySubjectTypeCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/10:40
 * @Description:
 */
@Data
public class QuerySubjectTypeCommand implements Serializable {

    private Long id;

    private IQuerySubjectTypeCommandHandler handler;

    public QuerySubjectTypeCommand(Long id){
        this();
        this.id=id;
    }

    public QuerySubjectTypeCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQuerySubjectTypeCommandHandler.class);
    }

    public List<SubjectTypeVo> execute() {
        List<SubjectTypeVo> action = handler.action(this);
        return action;
    }
}
