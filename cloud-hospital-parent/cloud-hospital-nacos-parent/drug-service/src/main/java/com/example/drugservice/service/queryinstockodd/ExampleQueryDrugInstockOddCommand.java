package com.example.drugservice.service.queryinstockodd;

import com.example.drugservice.inlet.web.vo.DrugInstockOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExampleQueryDrugInstockOddCommand {
    //表单提交查询条件
    private String no;
    //分页参数
    private Integer pageIndex;
    private Integer pageSize;
    @ApiModelProperty(hidden = true)
    private IExampleQueryDrugInstockOddCommandHandle handle;

    public ExampleQueryDrugInstockOddCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IExampleQueryDrugInstockOddCommandHandle.class);
    }
    public ExampleQueryDrugInstockOddCommand(String no){
        this();
        this.no=no;
    }

    public List<DrugInstockOddVo> execute(){
        List<DrugInstockOddVo> voList = handle.findByExample(this);
        return voList;
    }

}
