package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
@ApiModel
public class ExampleQueryDrugOddCommand {
        //表单提交查询条件
        private String no;

        private Long drugOddId;

        //分页参数
        private Integer pageIndex;
        private Integer pageSize;
        @ApiModelProperty(hidden = true)
        private IExampleQueryDrugOddCommandHandle handle ;



        public ExampleQueryDrugOddCommand(){
            this.handle=ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IExampleQueryDrugOddCommandHandle.class);
        }

        public ExampleQueryDrugOddCommand(Long drugOddId){
            this();
            this.drugOddId=drugOddId;
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

    //根据id查对象  里面去判断药品单状态是否已付款  没付款就把药品单药品退回药品库存里
    public void updateById(){
         handle.updateById(this.drugOddId);
         log.info("修改成功");
    }



}

