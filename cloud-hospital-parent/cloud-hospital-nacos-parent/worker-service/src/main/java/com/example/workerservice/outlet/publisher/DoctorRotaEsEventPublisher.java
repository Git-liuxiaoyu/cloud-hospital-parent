package com.example.workerservice.outlet.publisher;

import com.example.workerservice.outlet.dao.es.DoctorRotaEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DoctorRotaEsPo;
import com.example.workerservice.outlet.publisher.api.IDoctorRotaEsEventPublisher;
import com.example.workerservice.service.api.doctorrota.IUpdateDoctorRotaCommandHandler;
import com.example.workerservice.service.command.doctorrota.add.AddDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.update.UpdateDoctorRotaCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IDoctorRotaEsEventPublisher
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/26
 */
@Component
@Slf4j
public class DoctorRotaEsEventPublisher implements IDoctorRotaEsEventPublisher {

    /* 构造注入 - 开始 */
    private final DoctorRotaEsPoDao doctorRotaEsPoDao;

    public DoctorRotaEsEventPublisher(DoctorRotaEsPoDao doctorRotaEsPoDao) {
        this.doctorRotaEsPoDao = doctorRotaEsPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 添加进 Es
     *
     * @param event
     */
    @Override
    public void insert(AddDoctorRotaEsEvent event) {
        /* 转换成 source */
        AddDoctorRotaCommand command = (AddDoctorRotaCommand) event.getSource();
        /* 实例化 DoctorRotaEsPo */
        DoctorRotaEsPo doctorRotaEsPo = DoctorRotaEsPo.builder().id(command.getId()).departmentid(command.getDepartmentId()).doctorid(command.getDoctorId()).date(command.getDate()).rotatype(command.getRotaType()).shifttype(command.getShiftType()).maxpatient(command.getMaxPatient()).roomid(command.getRoomId()).createid(command.getCreateId()).createtime(command.getCreateTime()).status(command.getStatus()).build();
        /* 赋值 */
        doctorRotaEsPoDao.save(doctorRotaEsPo);
    }

    /**
     * 修改Es
     *
     * @param event
     */
    @Override
    public void update(UpdateDoctorRotaEsEvent event) {
        /* 转换成 source */
        UpdateDoctorRotaCommand command = (UpdateDoctorRotaCommand) event.getSource();
        /* 实例化 DoctorRotaEsPo */
        DoctorRotaEsPo doctorRotaEsPo = bulideDoctorRotaEsPo(event, UpdateDoctorRotaCommand.class);
        /* 判断是否未null */
        if (doctorRotaEsPo==null) {
            throw new IUpdateDoctorRotaCommandHandler.ClassTypeNotFoundException();
        }
        /* 存入 Es */
        doctorRotaEsPoDao.save(doctorRotaEsPo);
    }

    private DoctorRotaEsPo bulideDoctorRotaEsPo(ApplicationEvent event, Class clazz) {
        /* 判断是哪个类型的 Command */
        /* 判断是 UpdateDoctorRotaCommand */
        if (clazz.equals(UpdateDoctorRotaCommand.class)) {
            UpdateDoctorRotaCommand command = (UpdateDoctorRotaCommand) event.getSource();
            return DoctorRotaEsPo.builder().id(command.getId()).departmentid(command.getDepartmentId()).doctorid(command.getDoctorId()).date(command.getDate()).rotatype(command.getRotaType()).shifttype(command.getShiftType()).maxpatient(command.getMaxPatient()).roomid(command.getRoomId()).createid(command.getCreateId()).createtime(command.getCreateTime()).status(command.getStatus()).build();
        } else if (clazz.equals(AddDoctorRotaCommand.class)) {
            AddDoctorRotaCommand command = (AddDoctorRotaCommand) event.getSource();
            return DoctorRotaEsPo.builder().id(command.getId()).departmentid(command.getDepartmentId()).doctorid(command.getDoctorId()).date(command.getDate()).rotatype(command.getRotaType()).shifttype(command.getShiftType()).maxpatient(command.getMaxPatient()).roomid(command.getRoomId()).createid(command.getCreateId()).createtime(command.getCreateTime()).status(command.getStatus()).build();
        } else {
            /* 没有该指令 */
            return null;
        }
    }

}
