package com.example.drugservice.service.queryinstockodddetail;

import com.example.drugservice.inlet.web.vo.DrugInstockOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugInstockOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExampleQueryDrugInstockOddDetailCommand {
    //表单提交查询条件
    private Long instockOddId;

    private IExampleQueryDrugInstockOddDetailCommandHanle handle;

    public ExampleQueryDrugInstockOddDetailCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IExampleQueryDrugInstockOddDetailCommandHanle.class);
    }
    public ExampleQueryDrugInstockOddDetailCommand(Long instockOddId){
        this();
        this.instockOddId=instockOddId;
    }

    public List<DrugInstockOddDetailVo> execute(){
        List<DrugInstockOddDetailVo> voList = handle.findByInstockId(this.instockOddId);
        return voList;
    }

}
