package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
public class ExampleQueryInventoryOddCommand {
        //表单提交查询条件
        private String no;

        //分页参数
        private Integer pageIndex;
        private Integer pageSize;
        @ApiModelProperty(hidden = true)
        private IExampleQueryInventoryOddCommandHandle handle ;

        public ExampleQueryInventoryOddCommand(){
            this.handle=ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IExampleQueryInventoryOddCommandHandle.class);
        }

    public ExampleQueryInventoryOddCommand(String no) {
            this();
        this.no = no;

    }

    public List<InventoryOddVo> execute(){

        List<InventoryOddVo> list = handle.findList(this);
        return list;

    }
}

