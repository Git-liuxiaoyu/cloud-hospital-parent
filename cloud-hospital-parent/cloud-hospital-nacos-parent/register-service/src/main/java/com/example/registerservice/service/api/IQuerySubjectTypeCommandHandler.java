package com.example.registerservice.service.api;

import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.service.query.querysubjecttype.QuerySubjectTypeCommand;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:18
 * @Description: 查询所有科目类型接口
 */
public interface IQuerySubjectTypeCommandHandler {
    List<SubjectTypeVo> action(QuerySubjectTypeCommand command);
}
