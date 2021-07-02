package com.example.physicalexamservice.service.command.physicalexamreocrddetail.update;

import com.example.physicalexamservice.service.api.physicalexamrecorddetail.IUpdatePhysicalExamRecordDetailCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - UpdatePhysicalRecordDetailCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Data
@ApiModel
public class UpdatePhysicalExamRecordDetailCommand {

    @NotNull
    @ApiModelProperty(value = "体检详情主键ID")
    private Long id;

    @ApiModelProperty(value = "体检结果上传文件地址")
    private String resultfile;

    @NotNull
    @ApiModelProperty(value = "体检详情所属体检单的主键ID")
    private Long recordId;

    @NotNull
    @ApiModelProperty(value = "体检结果文本记录")
    private String resulttext;

    @NotNull
    @ApiModelProperty(value = "哪个医生体检的")
    private Integer examdocid;

    @ApiModelProperty(value = "体检详情状态", hidden = true)
    private String status;

    @ApiModelProperty(hidden = true)
    private String workerNo;

    @ApiModelProperty(hidden = true)
    private IUpdatePhysicalExamRecordDetailCommandHandler updatePhysicalRecordDetailCommandHandler;

    public UpdatePhysicalExamRecordDetailCommand() {
        this.updatePhysicalRecordDetailCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IUpdatePhysicalExamRecordDetailCommandHandler.class);
    }

    public UpdatePhysicalExamRecordDetailCommand(Long id, String resultfile, String resulttext, Integer examdocid, String status) {
        this();
        this.id = id;
        this.resultfile = resultfile;
        this.resulttext = resulttext;
        this.examdocid = examdocid;
        this.status = status;
    }

    public void execute() {
        /* 执行方法 */
        this.updatePhysicalRecordDetailCommandHandler.action(this);
    }
}
