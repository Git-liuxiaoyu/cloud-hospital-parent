package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import com.example.drugservice.util.PageUtils;
import com.github.pagehelper.PageInfo;
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
public class ExampleQueryDrugCommand {
        //表单提交查询条件
        @ApiModelProperty(value = "药品编号", example = "1")
        private String no;
    @ApiModelProperty(value = "药品名")
        private String name;
        @ApiModelProperty(value = "药品类型id", example = "1")
        private Integer typeId;
        @ApiModelProperty(value = "药品id", example = "1")
        private Integer id;
        @ApiModelProperty(value = "药品产地", example = "武汉")
        private String location;

        //分页参数
        @ApiModelProperty(value = "第几页", example = "1",required = true)
        private Integer pageIndex;
         @ApiModelProperty(value = "每页几条数据", example = "3",required = true)
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

