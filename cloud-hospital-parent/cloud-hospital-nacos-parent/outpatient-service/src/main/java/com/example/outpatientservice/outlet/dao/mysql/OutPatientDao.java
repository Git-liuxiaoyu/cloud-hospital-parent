package com.example.outpatientservice.outlet.dao.mysql;

import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OutPatientDao {
    long countByExample(OutPatientPoExample example);

    int deleteByExample(OutPatientPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OutPatientPo record);

    int insertSelective(OutPatientPo record);

    List<OutPatientPo> selectByExample(OutPatientPoExample example);

    OutPatientPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OutPatientPo record, @Param("example") OutPatientPoExample example);

    int updateByExample(@Param("record") OutPatientPo record, @Param("example") OutPatientPoExample example);

    int updateByPrimaryKeySelective(OutPatientPo record);

    int updateByPrimaryKey(OutPatientPo record);

    List<OutPatientPo> selectByCon(OutPatientPo po);
}