package com.example.physicalexamservice.service.command.physicalexamrecord.add;

import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordDetailEsEventPublisher;
import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordEsEventPublisher;
import com.example.physicalexamservice.service.api.physicalexamrecord.IAddPhysicalExamRecordCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
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
public class AddPhysicalExamRecordCommand {

    private Long id;

    private String no;

    private Date createTime;

    @NotNull
    private Long treatrecordid;

    @NotNull
    private Integer doctorid;

    @NotNull
    private Long patientid;

    @NotNull
    private List<InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList;

    private IAddPhysicalExamRecordCommandHandler addPhysicalExamRecordCommandHandler;

    /**
     * 内部类 - AddPhysicalExamRecord专用
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class InnerAddPhysicalExamRecordDetailPo {

        private Long id;

        private Integer typeid;

        private Integer examid;

        private Integer count;

        private BigDecimal price;
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

    public Long execute() {
        /* 执行方法 */
        Long recordId = this.addPhysicalExamRecordCommandHandler.action(this);

        /* Event Bus 通知 添加到 ElasticSearch */
        /* 添加 Record */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IPhysicalExamRecordEsEventPublisher.AddPhysicalExamRecordEsEvent(this));

        /* 返回 */
        return recordId;
    }


}
