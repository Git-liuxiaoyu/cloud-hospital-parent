package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import com.example.drugservice.util.PageUtils;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
public class ExampleQueryDrugCommand {
        //表单提交查询条件
        private String no;
        private String name;
        private Integer typeId;
        private Integer id;
        private String location;

        //分页参数
        private Integer pageIndex;
        private Integer pageSize;

        private IExampleQueryDrugCommandHandle handle ;

        public ExampleQueryDrugCommand(){
            this.handle=ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IExampleQueryDrugCommandHandle.class);
        }

    public ExampleQueryDrugCommand(String no, String name, Integer typeId, Integer id, String location) {
            this();
        this.no = no;
        this.name = name;
        this.typeId = typeId;
        this.id = id;
        this.location = location;
    }

    public List<DrugVo> execute(){
        List<DrugVo> list = handle.findList(this);

        return list;
    }
}

