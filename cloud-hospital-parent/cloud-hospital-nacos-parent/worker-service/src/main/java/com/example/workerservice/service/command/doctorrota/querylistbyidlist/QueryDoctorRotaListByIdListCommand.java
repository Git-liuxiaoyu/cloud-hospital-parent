package com.example.workerservice.service.command.doctorrota.querylistbyidlist;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IQueryDoctorRotaListByIdListCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * 实体类 - 命令 - QueryDoctorRotaByIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
public class QueryDoctorRotaListByIdListCommand {

    private List<Long> idList;

    private IQueryDoctorRotaListByIdListCommandHandler queryDoctorRotaByIdCommandHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @ApiModel
    @Builder(toBuilder = true)
    public static class DoctorRotaVo{

        @ApiModelProperty(value = "医生排班的主键ID", example = "1")
        private Long id;

        @ApiModelProperty(value = "科室主键ID", example = "1")
        private Integer departmentid;

        @ApiModelProperty(value = "科室名称", example = "心脏外科")
        private String departmentname;

        @ApiModelProperty(value = "该次排班医生的日期(yyyy-MM-dd)", example = "2021-06-23")
        private Date date;

        @ApiModelProperty(value = "这次排班的房间主键ID", example = "1")
        private Integer roomid;

        @ApiModelProperty(value = "该次排班医生的时间类型(上午班、下午班)", example = "1")
        private String shifttype;

        @ApiModelProperty(value = "该次排班医生的主键ID", example = "1")
        private Integer doctorid;

        @ApiModelProperty(value = "该次排班医生的名称", example = "张方松")
        private String doctorName;

        @ApiModelProperty(value = "该次排班医生的头像路径")
        private String doctorAvatar;

        /* 大于0就是专家号 */
        @ApiModelProperty(value = "该次排班医生的等级(0、普通，1、高级,2、主任)[大于0就是专家号]", example = "1")
        private String doctorLevel;

        @ApiModelProperty(value = "该次排班剩余的看诊人数", example = "33")
        private Integer leftpatient;

        @ApiModelProperty(value = "该次排班最大的看诊人数", example = "33")
        private Integer maxpatient;

        @ApiModelProperty(value = "该次排班的状态", example = "33")
        private String status;
    }


    public QueryDoctorRotaListByIdListCommand() {
        this.queryDoctorRotaByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryDoctorRotaListByIdListCommandHandler.class);
    }

    public QueryDoctorRotaListByIdListCommand(List<Long> idList) {
        this();
        this.idList = idList;
    }

    public List<DoctorRotaVo> execute() {
        /* 执行方法 */
        return this.queryDoctorRotaByIdCommandHandler.action(this);
    }

}
