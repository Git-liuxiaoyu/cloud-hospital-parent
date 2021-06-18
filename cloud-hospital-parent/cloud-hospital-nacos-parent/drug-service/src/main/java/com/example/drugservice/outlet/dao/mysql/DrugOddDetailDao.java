package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.DrugOddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddDetailPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugOddDetailDao {
    long countByExample(DrugOddDetailPoExample example);

    int deleteByExample(DrugOddDetailPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugOddDetailPo record);

    int insertSelective(DrugOddDetailPo record);

    List<DrugOddDetailPo> selectByExample(DrugOddDetailPoExample example);

    DrugOddDetailPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugOddDetailPo record, @Param("example") DrugOddDetailPoExample example);

    int updateByExample(@Param("record") DrugOddDetailPo record, @Param("example") DrugOddDetailPoExample example);

    int updateByPrimaryKeySelective(DrugOddDetailPo record);

    int updateByPrimaryKey(DrugOddDetailPo record);

    List<DrugOddDetailPo> selectByDrugoddId(Long drugoddId);
}