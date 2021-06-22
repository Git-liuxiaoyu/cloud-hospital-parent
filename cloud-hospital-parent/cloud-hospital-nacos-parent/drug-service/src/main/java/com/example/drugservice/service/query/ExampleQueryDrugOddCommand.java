package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
public class ExampleQueryDrugOddCommand {
        //表单提交查询条件
        private String no;

        //分页参数
        private Integer pageIndex;
        private Integer pageSize;

        private IExampleQueryDrugOddCommandHandle handle ;

        public ExampleQueryDrugOddCommand(){
            this.handle=ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IExampleQueryDrugOddCommandHandle.class);
        }

    public ExampleQueryDrugOddCommand(String no, String name, Integer typeId, Integer id, String location) {
            this();
        this.no = no;

    }
    //查集合
    public List<DrugOddVo> execute(){

        List<DrugOddVo> list = handle.findList(this);
        return list;
    }

    //查对象
    public DrugOddVo getByNo(){
          return   handle.getByNo(this.no);
    }


}

