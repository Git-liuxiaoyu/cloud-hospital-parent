package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.outlet.dao.mysql.WorkerInfoPoDao;
import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPo;
import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPoExample;
import com.example.workerservice.util.converter.WorkerInfoLoginedVoConverter;
import com.example.workerservice.util.converter.WorkerInfoVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 适配层 - 员工信息
 */
@Component
@Slf4j
public class WorkerInfoDaoAdapter {

    /* 构造注入 - 开始 */
    private final WorkerInfoPoDao workerInfoPoDao;

    private final WorkerInfoVoConverter workerInfoVoConverter;

    private final WorkerInfoLoginedVoConverter workerInfoLoginedVoConverter;

    public WorkerInfoDaoAdapter(WorkerInfoPoDao workerInfoPoDao, WorkerInfoVoConverter workerInfoVoConverter, WorkerInfoLoginedVoConverter workerInfoLoginedVoConverter) {
        this.workerInfoPoDao = workerInfoPoDao;
        this.workerInfoVoConverter = workerInfoVoConverter;
        this.workerInfoLoginedVoConverter = workerInfoLoginedVoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 通过工号获得
     *
     * @param workerNo
     * @return
     */
    public WorkerInfoVo queryByWorkerNo(String workerNo) {
        /* 查询 */
        WorkerInfoPo workerInfoPo = workerInfoPoDao.queryByWorkerNo(workerNo).orElseThrow(NullPointerException::new);
        /* 转换并返回 */
        return workerInfoVoConverter.convert(workerInfoPo);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    public WorkerInfoVo queryById(Integer id) {
        /* 查询 */
        WorkerInfoPo workerInfoPo = workerInfoPoDao.selectByPrimaryKey(id).orElseThrow(NullPointerException::new);
        /* 转换并返回 */
        return workerInfoVoConverter.convert(workerInfoPo);
    }

    /**
     * 通过工号获得
     *
     * @param workerNo
     * @return
     */
    public WorkerInfoLoginedVo queryLoginedByWorkerNo(String workerNo) {
        /* 查询 */
        WorkerInfoPo workerInfoPo = workerInfoPoDao.queryLoginedWorkerInfoByWorkerNo(workerNo).orElseThrow(NegativeArraySizeException::new);
        /* LOG */
        log.info("工号 [{}] 成功获取信息 [{}]", workerNo, workerInfoPo);
        /* 转换并返回 */
        return workerInfoLoginedVoConverter.convert(workerInfoPo);
    }

    /**
     * 通过DepartId获得所有List
     *
     * @param departmentId
     * @param status
     * @return
     */
    public List<WorkerInfoVo> queryListByDepartId(Integer departmentId, String status) {
        /* 实例化 WorkerInfoPoExample */
        WorkerInfoPoExample workerInfoPoExample = new WorkerInfoPoExample();
        /* 编写条件 */
        workerInfoPoExample.createCriteria().andDepartmentidEqualTo(departmentId).andStatusEqualTo(status);
        /* 调用方法 */
        List<WorkerInfoPo> workerInfoPoList = workerInfoPoDao.selectByExample(workerInfoPoExample);
        /* 转换为Vo */
        List<WorkerInfoVo> workerInfoVoList = workerInfoVoConverter.convert(workerInfoPoList);
        /* 返回 */
        return workerInfoVoList;
    }
}
