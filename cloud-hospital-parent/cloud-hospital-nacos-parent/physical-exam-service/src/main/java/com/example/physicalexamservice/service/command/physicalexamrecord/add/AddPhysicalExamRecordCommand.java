package com.example.physicalexamservice.service.command.physicalexamrecord.add;

import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordEsEventPublisher;
import com.example.physicalexamservice.service.api.physicalexamrecord.IAddPhysicalExamRecordCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 实体类 - 命令 - AddPhysicalExamRecordCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@ApiModel
public class AddPhysicalExamRecordCommand {

    @ApiModelProperty(value = "体检记录主键ID", example = "1",hidden = true)
    private Long id;

    @ApiModelProperty(value = "体检记录编号No",hidden = true)
    private String no;

    @ApiModelProperty(value = "体检记录创建时间",hidden = true)
    private Date createTime;

    @NotNull
    @ApiModelProperty(value = "就诊记录主键ID", example = "1", required = true)
    private Long treatrecordid;

    @NotNull
    @ApiModelProperty(value = "发起这个体检单(记录)请求得医生(员工)主键ID", example = "1", required = true)
    private Integer doctorid;

    @NotNull
    @ApiModelProperty(value = "这个体检单(记录)给哪个病人体检得主键ID", example = "1", required = true)
    private Long patientid;

    @NotNull
    @ApiModelProperty(value = "需要添加到", example = "1", required = true)
    private List<InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList;

    @ApiModelProperty(hidden = true)
    private IAddPhysicalExamRecordCommandHandler addPhysicalExamRecordCommandHandler;

    /**
     * 内部类 - AddPhysicalExamRecord专用
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @ApiModel
    public static class InnerAddPhysicalExamRecordDetailPo {

        @ApiModelProperty(value = "体检记录详情主键ID", example = "1")
        private Long id;

        @ApiModelProperty(value = "体检记录详情得体检类型主键ID(体检的项目是哪个类型)", example = "1",required = true)
        @NotNull
        private Integer typeid;

        private String typeName;

        @ApiModelProperty(value = "体检记录详情得体检的是哪个项目(体检项目主键ID)", example = "1",required = true)
        @NotNull
        private Integer examid;

        private String examName;

        @ApiModelProperty(value = "体检记录详情得体检项目检查次数", example = "1",required = true)
        @NotNull
        private Integer count;

        @ApiModelProperty(value = "体检记录详情得体检项目的金额", example = "1.00")
        private BigDecimal price;

        private String status;

    }

    public AddPhysicalExamRecordCommand() {
        this.addPhysicalExamRecordCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IAddPhysicalExamRecordCommandHandler.class);
    }

    public AddPhysicalExamRecordCommand(Long treatrecordid, Integer doctorid, Long patientid, List<InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList) {
        this();
        this.treatrecordid = treatrecordid;
        this.doctorid = doctorid;
        this.patientid = patientid;
        this.innerAddPhysicalExamRecordDetailPoList = innerAddPhysicalExamRecordDetailPoList;
    }

    public String execute() {
        /* 执行方法 */
        String recordIdAndRecordNo = this.addPhysicalExamRecordCommandHandler.action(this);

        /* Event Bus 通知 添加到 ElasticSearch */
        /* 添加 Record */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IPhysicalExamRecordEsEventPublisher.AddPhysicalExamRecordEsEvent(this));

        /* 返回 */
        return recordIdAndRecordNo;
    }


}
