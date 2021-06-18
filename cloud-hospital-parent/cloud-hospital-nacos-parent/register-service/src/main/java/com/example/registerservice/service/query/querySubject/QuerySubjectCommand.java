package com.example.registerservice.service.query.querysubject;

import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.api.IQuerySubjectCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/10:40
 * @Description:
 */
public class QuerySubjectCommand implements Serializable {

    private IQuerySubjectCommandHandler handler;

    public QuerySubjectCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQuerySubjectCommandHandler.class);
    }

    public List<SubjectVo> execute() {
        List<SubjectVo> action = handler.action();
        return action;
    }
}
