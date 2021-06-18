package com.example.registerservice.service.api;

import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.query.querysubject.QuerySubjectCommand;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:17
 * @Description: 查询所有科目接口
 */
public interface IQuerySubjectCommandHandler {
    List<SubjectVo> action();
}
