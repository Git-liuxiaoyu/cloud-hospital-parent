package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.outlet.dao.mysql.OutRoomPoDao;
import com.example.workerservice.outlet.dao.mysql.po.OutRoomPo;
import com.example.workerservice.outlet.dao.mysql.po.OutRoomPoExample;
import com.example.workerservice.outlet.dao.redis.OutRoomRedisPoDao;
import com.example.workerservice.outlet.dao.redis.po.OutRoomRedisPo;
import com.example.workerservice.util.converter.OutRoomRedisPoConverter;
import com.example.workerservice.util.converter.OutRoomVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器类 - 适配 - OutRoom
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class OutRoomDaoAdapter {

    /* 构造注入 - BEGIN */
    private final OutRoomPoDao outRoomPoDao;

    private final OutRoomRedisPoDao outRoomRedisPoDao;

    private final OutRoomVoConverter outRoomVoConverter;

    private final OutRoomRedisPoConverter outRoomRedisPoConverter;

    public OutRoomDaoAdapter(OutRoomPoDao outRoomPoDao, OutRoomVoConverter outRoomVoConverter, OutRoomRedisPoDao outRoomRedisPoDao, OutRoomRedisPoConverter outRoomRedisPoConverter) {
        this.outRoomPoDao = outRoomPoDao;
        this.outRoomVoConverter = outRoomVoConverter;
        this.outRoomRedisPoDao = outRoomRedisPoDao;
        this.outRoomRedisPoConverter = outRoomRedisPoConverter;
    }
    /* 构造注入 - END */

    /**
     * 根据ID获取OutRoom
     *
     * @param id
     * @return
     */
    public OutRoomVo queryOutRoomById(Long id) {
        /* 调用方法查询 */
        OutRoomPo outRoomPo = outRoomPoDao.selectByPrimaryKey(id).orElseThrow(NullPointerException::new);
        /* 转换返回 */
        return outRoomVoConverter.convert(outRoomPo);
    }

    /**
     * 根据DepartId查询所有Room
     *
     * @param departmentId
     * @param status
     * @return
     */
    public List<OutRoomVo> queryOutRoomListByDepartId(Integer departmentId, String status) {
        /* 声明 */
        List<OutRoomVo> outRoomVoList = new ArrayList<>();

        try {
            /* 先去 Redis 查询 */
            List<OutRoomRedisPo> outRoomRedisPoList = outRoomRedisPoDao.findAllByDepartmentidEqualsAndStatusEquals(departmentId, status);
            /* 判断是否有值 */
            if (outRoomRedisPoList.isEmpty()) {
                throw new NullPointerException();
            }
            /* 转换Vo */
            outRoomVoList = outRoomVoConverter.convert(outRoomRedisPoList);
            /* LOG */
            log.info("从 Redis 中取出科室 [{}] 房间 [{}]",departmentId, outRoomVoList);
        } catch (NullPointerException e) {
            /* 实例化 */
            OutRoomPoExample outRoomPoExample = new OutRoomPoExample();
            /* 创造条件 */
            outRoomPoExample.createCriteria().andDepartmentidEqualTo(departmentId).andStatusEqualTo(status);
            /* 调用方法 */
            List<OutRoomPo> outRoomPoList = outRoomPoDao.selectByExample(outRoomPoExample);
            /* 转换Vo */
            outRoomVoList = outRoomVoConverter.convert(outRoomPoList);
            /* 转换 RedisPo */
            List<OutRoomRedisPo> outRoomRedisPoList = outRoomRedisPoConverter.convert(outRoomPoList);
            /* 存入 Redis */
            outRoomRedisPoDao.saveAll(outRoomRedisPoList);
            /* LOG */
            log.info("从 MySQL 中取出科室 [{}] 房间 [{}]",departmentId, outRoomVoList);
        }
        /* 返回 */
        return outRoomVoList;
    }
}
