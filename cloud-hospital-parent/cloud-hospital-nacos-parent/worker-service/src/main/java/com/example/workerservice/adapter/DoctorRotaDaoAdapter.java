package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.outlet.dao.es.DepartmentEsPoDao;
import com.example.workerservice.outlet.dao.es.DoctorRotaEsPoDao;
import com.example.workerservice.outlet.dao.es.PositionEsPoDao;
import com.example.workerservice.outlet.dao.es.WorkerInfoEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DepartmentEsPo;
import com.example.workerservice.outlet.dao.es.po.DoctorRotaEsPo;
import com.example.workerservice.outlet.dao.es.po.PositionEsPo;
import com.example.workerservice.outlet.dao.es.po.WorkerInfoEsPo;
import com.example.workerservice.outlet.dao.mysql.DoctorRotaPoDao;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPoExample;
import com.example.workerservice.outlet.dao.redis.DoctorRotaRedisPoDao;
import com.example.workerservice.service.command.doctorrota.querylistbyidlist.QueryDoctorRotaListByIdListCommand;
import com.example.workerservice.service.command.doctorrota.regquery.RegBackQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.regquery.RegQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.rotaquery.RotaQueryDoctorRotaCommand;
import com.example.workerservice.util.converter.DoctorRotaRedisPoConverter;
import com.example.workerservice.util.converter.DoctorRotaSetVoConverter;
import com.example.workerservice.util.converter.DoctorRotaVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 适配器类 - 适配 - DoctorRotaDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class DoctorRotaDaoAdapter {

    /* 构造注入 - 开始 */
    private final DoctorRotaPoDao doctorRotaPoDao;

    private final DoctorRotaRedisPoDao doctorRotaRedisPoDao;

    private final DoctorRotaEsPoDao doctorRotaEsPoDao;

    private final DepartmentEsPoDao departmentEsPoDao;

    private final WorkerInfoEsPoDao workerInfoEsPoDao;

    private final PositionEsPoDao positionEsPoDao;

    private final DoctorRotaVoConverter doctorRotaVoConverter;

    private final DoctorRotaRedisPoConverter doctorRotaRedisPoConverter;

    private final DoctorRotaSetVoConverter doctorRotaSetVoConverter;

    public DoctorRotaDaoAdapter(DoctorRotaPoDao doctorRotaPoDao, DoctorRotaRedisPoDao doctorRotaRedisPoDao, DoctorRotaVoConverter doctorRotaVoConverter, DoctorRotaRedisPoConverter doctorRotaRedisPoConverter, DoctorRotaSetVoConverter doctorRotaSetVoConverter, DoctorRotaEsPoDao doctorRotaEsPoDao, DepartmentEsPoDao departmentEsPoDao, WorkerInfoEsPoDao workerInfoEsPoDao, PositionEsPoDao positionEsPoDao) {
        this.doctorRotaPoDao = doctorRotaPoDao;
        this.doctorRotaRedisPoDao = doctorRotaRedisPoDao;
        this.doctorRotaVoConverter = doctorRotaVoConverter;
        this.doctorRotaRedisPoConverter = doctorRotaRedisPoConverter;
        this.doctorRotaSetVoConverter = doctorRotaSetVoConverter;
        this.doctorRotaEsPoDao = doctorRotaEsPoDao;
        this.departmentEsPoDao = departmentEsPoDao;
        this.workerInfoEsPoDao = workerInfoEsPoDao;
        this.positionEsPoDao = positionEsPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 根据 日期 - 科室 - 状态 查询
     *
     * @param date
     * @param departmentId
     * @param status
     */
    public List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> backQuery(Date date, Integer departmentId, String status, String doctorType, String shiftType) {
        /* 直接Es 查 */
        List<DoctorRotaEsPo> doctorRotaEsPoList = doctorRotaEsPoDao.findAllByStatusEqualsAndDepartmentidEqualsAndDateEqualsAndShifttypeEquals(status, departmentId, date, shiftType);
        /* 转换 List<DoctorRotaEsPo> -> List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> */
        List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> doctorRotaVoList = convertBack(doctorRotaEsPoList, doctorType);
        /* 返回 */
        return doctorRotaVoList;
    }

    /**
     * List<DoctorRotaEsPo> -> List<RegBackQueryDoctorRotaCommand.DoctorRotaVo>
     *
     * @param doctorRotaEsPoList
     * @return
     */
    private List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> convertBack(List<DoctorRotaEsPo> doctorRotaEsPoList, String doctorType) {
        /* 实例化 List<DoctorRotaEsPo> -> List<RegQueryDoctorRotaCommand.DoctorRotaVo> */
        List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> doctorRotaVoList = new ArrayList<>();
        /* 循环赋值 */
        doctorRotaEsPoList.forEach(doctorRotaEsPo -> {
            /* 转换 */
            RegBackQueryDoctorRotaCommand.DoctorRotaVo doctorRotaVo = convertBack(doctorRotaEsPo, doctorType);
            /* 判断是否为 null */
            if (doctorRotaVo == null) {
                return;
            }
            doctorRotaVoList.add(doctorRotaVo);
        });
        /* 返回 */
        return doctorRotaVoList;
    }

    private RegBackQueryDoctorRotaCommand.DoctorRotaVo convertBack(DoctorRotaEsPo doctorRotaEsPo, String doctorType) {
        /* 判断为 null */
        if (doctorRotaEsPo == null) {
            return null;
        }
        /* 实例化 */
        RegBackQueryDoctorRotaCommand.DoctorRotaVo doctorRotaVo = new RegBackQueryDoctorRotaCommand.DoctorRotaVo();
        /* 去查其他EsPo */
        doctorRotaEsPo.setWorkerInfo(workerInfoEsPoDao.findById(doctorRotaEsPo.getDoctorid()).orElse(new WorkerInfoEsPo()));
        doctorRotaEsPo.getWorkerInfo().setPosition(positionEsPoDao.findById(doctorRotaEsPo.getWorkerInfo().getPositionid()).orElse(new PositionEsPo()));
        doctorRotaEsPo.setDepartment(departmentEsPoDao.findById(doctorRotaEsPo.getDepartmentid()).orElse(new DepartmentEsPo()));
        /* 判断是否满足等级要求 */
        if (doctorRotaEsPo.getWorkerInfo() != null || doctorRotaEsPo.getWorkerInfo().getPosition() != null || doctorType.equals("0") || doctorRotaEsPo.getWorkerInfo().getPosition().getLevel().equals("0")) {
            /* 判断 */
            doctorRotaVo.setDepartmentname(doctorRotaEsPo.getDepartment().getName());
            doctorRotaVo.setMaxpatient(doctorRotaEsPo.getMaxpatient());
            doctorRotaVo.setId(doctorRotaEsPo.getId());
            doctorRotaVo.setDepartmentid(doctorRotaEsPo.getDepartmentid());
            doctorRotaVo.setShifttype(doctorRotaEsPo.getShifttype());
            doctorRotaVo.setLeftpatient(doctorRotaEsPo.getLeftpatient());
            doctorRotaVo.setDoctorid(doctorRotaEsPo.getDoctorid());
            doctorRotaVo.setDoctorName(doctorRotaEsPo.getWorkerInfo().getName());
            doctorRotaVo.setDoctorAvatar(doctorRotaEsPo.getWorkerInfo().getAvatar());
            doctorRotaVo.setDoctorLevel(doctorRotaEsPo.getWorkerInfo().getPosition().getLevel());
            doctorRotaVo.setDate(doctorRotaEsPo.getDate());
            doctorRotaVo.setStatus(doctorRotaEsPo.getStatus());
            /* 返回 */
            return doctorRotaVo;
        } else if (doctorRotaEsPo.getWorkerInfo() != null || doctorRotaEsPo.getWorkerInfo().getPosition() != null || doctorType.equals("1") || Integer.parseInt(doctorRotaEsPo.getWorkerInfo().getPosition().getLevel()) > 0) {
            /* 判断 */
            doctorRotaVo.setDepartmentname(doctorRotaEsPo.getDepartment().getName());
            doctorRotaVo.setMaxpatient(doctorRotaEsPo.getMaxpatient());
            doctorRotaVo.setId(doctorRotaEsPo.getId());
            doctorRotaVo.setDepartmentid(doctorRotaEsPo.getDepartmentid());
            doctorRotaVo.setShifttype(doctorRotaEsPo.getShifttype());
            doctorRotaVo.setLeftpatient(doctorRotaEsPo.getLeftpatient());
            doctorRotaVo.setDoctorid(doctorRotaEsPo.getDoctorid());
            doctorRotaVo.setDoctorName(doctorRotaEsPo.getWorkerInfo().getName());
            doctorRotaVo.setDoctorAvatar(doctorRotaEsPo.getWorkerInfo().getAvatar());
            doctorRotaVo.setDoctorLevel(doctorRotaEsPo.getWorkerInfo().getPosition().getLevel());
            doctorRotaVo.setDate(doctorRotaEsPo.getDate());
            doctorRotaVo.setStatus(doctorRotaEsPo.getStatus());
            /* 返回 */
            return doctorRotaVo;
        } else {
            return null;
        }
    }


    /**
     * 根据 日期 - 科室 - 状态 查询
     *
     * @param date
     * @param departmentId
     * @param status
     */
    public List<RegQueryDoctorRotaCommand.DoctorRotaVo> query(Date date, Integer departmentId, String status) {
        /* 直接 Es 查 */
        List<DoctorRotaEsPo> doctorRotaEsPoList = doctorRotaEsPoDao.findAllByDateEqualsAndDepartmentidEqualsAndStatusEquals(date, departmentId, status);
        /* 转换 List<DoctorRotaEsPo> -> List<RegQueryDoctorRotaCommand.DoctorRotaVo> */
        List<RegQueryDoctorRotaCommand.DoctorRotaVo> doctorRotaVoList = convert(doctorRotaEsPoList);
        /* 回传 */
        return doctorRotaVoList;
    }

    /**
     * List<DoctorRotaEsPo> -> List<RegQueryDoctorRotaCommand.DoctorRotaVo>
     *
     * @param doctorRotaEsPoList
     * @return
     */
    private List<RegQueryDoctorRotaCommand.DoctorRotaVo> convert(List<DoctorRotaEsPo> doctorRotaEsPoList) {
        /* 实例化 List<DoctorRotaEsPo> -> List<RegQueryDoctorRotaCommand.DoctorRotaVo> */
        List<RegQueryDoctorRotaCommand.DoctorRotaVo> doctorRotaVoList = new ArrayList<>();
        /* 循环赋值 */
        doctorRotaEsPoList.forEach(doctorRotaEsPo -> doctorRotaVoList.add(convert(doctorRotaEsPo)));
        /* 返回 */
        return doctorRotaVoList;
    }

    /**
     * DoctorRotaEsPo -> RegQueryDoctorRotaCommand.DoctorRotaVo
     *
     * @param doctorRotaEsPo
     * @return
     */
    private RegQueryDoctorRotaCommand.DoctorRotaVo convert(DoctorRotaEsPo doctorRotaEsPo) {
        /* 实例化 */
        RegQueryDoctorRotaCommand.DoctorRotaVo doctorRotaVo = new RegQueryDoctorRotaCommand.DoctorRotaVo();
        /* 判断为 null */
        if (doctorRotaEsPo == null) {
            return doctorRotaVo;
        }
        /* 去查其他EsPo */
        doctorRotaEsPo.setWorkerInfo(workerInfoEsPoDao.findById(doctorRotaEsPo.getDoctorid()).orElse(new WorkerInfoEsPo()));
        doctorRotaEsPo.getWorkerInfo().setPosition(positionEsPoDao.findById(doctorRotaEsPo.getWorkerInfo().getPositionid()).orElse(new PositionEsPo()));
        doctorRotaEsPo.setDepartment(departmentEsPoDao.findById(doctorRotaEsPo.getDepartmentid()).orElse(new DepartmentEsPo()));
        doctorRotaVo.setDepartmentname(doctorRotaEsPo.getDepartment().getName());
        doctorRotaVo.setMaxpatient(doctorRotaEsPo.getMaxpatient());
        doctorRotaVo.setId(doctorRotaEsPo.getId());
        doctorRotaVo.setDepartmentid(doctorRotaEsPo.getDepartmentid());
        doctorRotaVo.setShifttype(doctorRotaEsPo.getShifttype());
        doctorRotaVo.setLeftpatient(doctorRotaEsPo.getLeftpatient());
        doctorRotaVo.setDoctorid(doctorRotaEsPo.getDoctorid());
        doctorRotaVo.setDoctorName(doctorRotaEsPo.getWorkerInfo().getName());
        doctorRotaVo.setDoctorAvatar(doctorRotaEsPo.getWorkerInfo().getAvatar());
        doctorRotaVo.setDoctorLevel(doctorRotaEsPo.getWorkerInfo().getPosition().getLevel());
        doctorRotaVo.setDate(doctorRotaEsPo.getDate());
        doctorRotaVo.setStatus(doctorRotaEsPo.getStatus());
        /* 返回 */
        return doctorRotaVo;
    }


    /**
     * 添加排班方法
     *
     * @param departmentId
     * @param doctorId
     * @param date
     * @param rotaType
     * @param shiftType
     * @param maxPatient
     * @param roomId
     * @param createId
     * @param createTime
     * @param status
     * @return
     */
    public Long addDoctorRota(Integer departmentId, Integer doctorId, Date date, String rotaType, String
            shiftType, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status) {
        /* 实例化 */
        DoctorRotaPo doctorRotaPo = new DoctorRotaPo();
        /* 赋值 */
        copyProps(departmentId, doctorId, date, rotaType, shiftType, maxPatient, roomId, createId, createTime, status, doctorRotaPo);
        /* 调用insert */
        doctorRotaPoDao.insert(doctorRotaPo);
        /* 返回主键 */
        return doctorRotaPo.getId();
    }

    /**
     * 查询
     *
     * @param departmentId
     * @param date
     * @param shiftType
     * @param status
     * @return
     */
    public List<RotaQueryDoctorRotaCommand.DoctorRotaVo> query(Integer departmentId, Date date, String shiftType, String status) {
        /* 实例化 */
        DoctorRotaPoExample doctorRotaPoExample = new DoctorRotaPoExample();
        /* 创造条件 */
        doctorRotaPoExample.createCriteria().andDepartmentidEqualTo(departmentId).andDateEqualTo(date).andShifttypeEqualTo(shiftType).andStatusEqualTo(status);
        /* 调用方法 */
        /* 转换 - 返回 */
        return convert(doctorRotaPoDao.selectByExample(doctorRotaPoExample));
    }

    /**
     * List<DoctorRotaPo> -> List<RotaQueryDoctorRotaCommand.DoctorRotaVo>
     *
     * @param doctorRotaPoList
     * @return
     */
    private List<RotaQueryDoctorRotaCommand.DoctorRotaVo> convert(Iterable<DoctorRotaPo> doctorRotaPoList) {
        /* 实例化 List<RotaQueryDoctorRotaCommand.DoctorRotaVo> */
        List<RotaQueryDoctorRotaCommand.DoctorRotaVo> doctorRotaVoList = new ArrayList<>();
        /* 循环转换 */
        doctorRotaPoList.forEach(d -> doctorRotaVoList.add(convert(d)));
        /* 返回 */
        return doctorRotaVoList;
    }

    /**
     * DoctorRotaPo -> RotaQueryDoctorRotaCommand.DoctorRotaVo
     *
     * @param doctorRotaPo
     * @return
     */
    private RotaQueryDoctorRotaCommand.DoctorRotaVo convert(DoctorRotaPo doctorRotaPo) {
        /* 实例化  RotaQueryDoctorRotaCommand.DoctorRotaVo */
        return RotaQueryDoctorRotaCommand.DoctorRotaVo.builder().doctorid(doctorRotaPo.getDoctorid()).roomid(doctorRotaPo.getRoomid()).maxpatient(doctorRotaPo.getMaxpatient()).status(doctorRotaPo.getStatus()).id(doctorRotaPo.getId()).build();
    }

    /**
     * 更新排班
     *
     * @param id
     * @param departmentId
     * @param doctorId
     * @param date
     * @param rotaType
     * @param shiftType
     * @param maxPatient
     * @param roomId
     * @param createId
     * @param createTime
     * @param status
     */
    public void updateDoctorRota(Long id, Integer departmentId, Integer doctorId, Date date, String
            rotaType, String shiftType, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status) {
        /* 实例化 */
        DoctorRotaPo doctorRotaPo = new DoctorRotaPo();
        /* 赋值 */
        doctorRotaPo.setId(id);
        /* 复制属性 */
        copyProps(departmentId, doctorId, date, rotaType, shiftType, maxPatient, roomId, createId, createTime, status, doctorRotaPo);
        /* 更新 */
        doctorRotaPoDao.updateByPrimaryKeySelective(doctorRotaPo);
    }

    /**
     * 复制属性
     *
     * @param departmentId
     * @param doctorId
     * @param date
     * @param rotaType
     * @param shiftType
     * @param maxPatient
     * @param roomId
     * @param createId
     * @param createTime
     * @param status
     * @param doctorRotaPo
     */
    private void copyProps(Integer departmentId, Integer doctorId, Date date, String rotaType, String
            shiftType, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status, DoctorRotaPo
                                   doctorRotaPo) {
        doctorRotaPo.setDepartmentid(departmentId);
        doctorRotaPo.setDate(date);
        doctorRotaPo.setRotatype(rotaType);
        doctorRotaPo.setShifttype(shiftType);
        doctorRotaPo.setDoctorid(doctorId);
        doctorRotaPo.setLeftpatient(maxPatient);
        doctorRotaPo.setMaxpatient(maxPatient);
        doctorRotaPo.setRoomid(roomId);
        doctorRotaPo.setCreateid(createId);
        doctorRotaPo.setCreatetime(createTime);
        doctorRotaPo.setStatus(status);
    }

    /**
     * 判断想要排班的医生是否同时排班在别的诊室
     *
     * @param date
     * @param shiftType
     * @param departmentId
     */
    public void queryDoctorRotaToCheckIsDoctorInOtherRoomSameTimeAdd(Integer doctorId, Date date, String
            shiftType, Integer departmentId, String status) {
        /* 实例化 DoctorRotaPoExample */
        DoctorRotaPoExample doctorRotaPoExample = new DoctorRotaPoExample();
        /* 编写条件 */
        doctorRotaPoExample.createCriteria().andDateEqualTo(date).andShifttypeEqualTo(shiftType).andDepartmentidEqualTo(departmentId).andDoctoridEqualTo(doctorId).andStatusEqualTo(status);
        /* 调用方法 */
        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.selectByExample(doctorRotaPoExample);
        /* 判断是否为唯一 */
        if (!doctorRotaPoList.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 判断想要排班的医生是否同时排班在别的诊室
     *
     * @param date
     * @param shiftType
     * @param departmentId
     */
    public void queryDoctorRotaToCheckIsDoctorInOtherRoomSameTimeUpdate(Integer doctorId, Date date, String
            shiftType, Integer departmentId, String status) {
        /* 实例化 DoctorRotaPoExample */
        DoctorRotaPoExample doctorRotaPoExample = new DoctorRotaPoExample();
        /* 编写条件 */
        doctorRotaPoExample.createCriteria().andDateEqualTo(date).andShifttypeEqualTo(shiftType).andDepartmentidEqualTo(departmentId).andDoctoridEqualTo(doctorId).andStatusEqualTo(status);
        /* 调用方法 */
        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.selectByExample(doctorRotaPoExample);
        /* 判断是否为唯一 */
        if (!doctorRotaPoList.isEmpty() && doctorRotaPoList.size() != 1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 修改状态
     *
     * @param id
     * @param status
     */
    public void updateDoctorRotaStatus(Long id, String status) {
        /* 查询是否存在该ID */
        if (doctorRotaPoDao.selectByPrimaryKey(id) == null) {
            /* 不存在该ID抛异常 */
            throw new NullPointerException();
        }

        /* 实例化 DoctorRotaPo */
        DoctorRotaPo doctorRotaPo = new DoctorRotaPo();
        /* 赋值 */
        doctorRotaPo.setStatus(status);
        doctorRotaPo.setId(id);
        /* 调用方法 */
        doctorRotaPoDao.updateByPrimaryKeySelective(doctorRotaPo);
    }

    /**
     * 根据ID搜索
     *
     * @param id
     * @return
     */
    public DoctorRotaVo query(Long id) {
        /* 调用方法,转换返回 */
        return doctorRotaVoConverter.convert(doctorRotaPoDao.getById(id));
    }

    /**
     * @param idList
     * @return
     */
    public List<QueryDoctorRotaListByIdListCommand.DoctorRotaVo> query(List<Long> idList) {
        /* 调用方法 */
        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.findByIdList(idList);
        /* 实例化对象 */
        List<QueryDoctorRotaListByIdListCommand.DoctorRotaVo> doctorRotaVoList = new ArrayList<>();
        /* 循环赋值 */
        doctorRotaPoList.forEach(doctorRotaPo -> doctorRotaVoList.add(QueryDoctorRotaListByIdListCommand.DoctorRotaVo.builder()
                .departmentname(doctorRotaPo.getDepartmentPo().getName())
                .maxpatient(doctorRotaPo.getMaxpatient())
                .id(doctorRotaPo.getId())
                .departmentid(doctorRotaPo.getDepartmentid())
                .shifttype(doctorRotaPo.getShifttype())
                .leftpatient(doctorRotaPo.getLeftpatient())
                .doctorid(doctorRotaPo.getDoctorid())
                .doctorName(doctorRotaPo.getWorkerInfoPo().getName())
                .doctorAvatar(doctorRotaPo.getWorkerInfoPo().getAvatar())
                .doctorLevel(doctorRotaPo.getWorkerInfoPo().getPositionPo().getLevel())
                .date(doctorRotaPo.getDate())
                .status(doctorRotaPo.getStatus())
                .build()));
        /* 转换返回 */
        return doctorRotaVoList;
    }


}
