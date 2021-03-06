package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPoExample;

import java.util.Date;
import java.util.List;

import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRotaPoDao {
    long countByExample(DoctorRotaPoExample example);

    int deleteByExample(DoctorRotaPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DoctorRotaPo record);

    int insertSelective(DoctorRotaPo record);

    List<DoctorRotaPo> selectByExample(DoctorRotaPoExample example);

    DoctorRotaPo selectByPrimaryKey(Long id);

    List<DoctorRotaPo> findAllByStatusEqualsAndDepartmentidEqualsAndDateEquals(@Param("status") String status, @Param("departmentId") Integer departmentId , @Param("date") Date date);

    int updateByExampleSelective(@Param("record") DoctorRotaPo record, @Param("example") DoctorRotaPoExample example);

    int updateByExample(@Param("record") DoctorRotaPo record, @Param("example") DoctorRotaPoExample example);

    int updateByPrimaryKeySelective(DoctorRotaPo record);

    int updateByPrimaryKey(DoctorRotaPo record);

    DoctorRotaPo getById(Long id);

    List<DoctorRotaPo> findByIdList(List<Long> idList);
}