package com.example.outpatientservice.outlet.dao.mysql;

import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientRecordPo;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientRecordPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OutPatientRecordDao {
    long countByExample(OutPatientRecordPoExample example);

    int deleteByExample(OutPatientRecordPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OutPatientRecordPo record);

    int insertSelective(OutPatientRecordPo record);

    List<OutPatientRecordPo> selectByExample(OutPatientRecordPoExample example);

    OutPatientRecordPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OutPatientRecordPo record, @Param("example") OutPatientRecordPoExample example);

    int updateByExample(@Param("record") OutPatientRecordPo record, @Param("example") OutPatientRecordPoExample example);

    int updateByPrimaryKeySelective(OutPatientRecordPo record);

    int updateByPrimaryKey(OutPatientRecordPo record);
}