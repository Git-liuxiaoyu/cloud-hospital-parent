package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
public class ExampleQueryDrugOddDetailCommand {
        //表单提交查询条件
        private Long drugoddid;

     @ApiModelProperty(hidden = true)
        private IExampleQueryDrugOddDetailCommandHandle handle;

        public ExampleQueryDrugOddDetailCommand(){
            this.handle=ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IExampleQueryDrugOddDetailCommandHandle.class);
        }

        public ExampleQueryDrugOddDetailCommand(Long drugoddid){
            this();
            this.drugoddid=drugoddid;
        }



    public List<DrugOddDetailVo> execute(){
        return handle.findListByDrugOddId(this.drugoddid);
    }
}

