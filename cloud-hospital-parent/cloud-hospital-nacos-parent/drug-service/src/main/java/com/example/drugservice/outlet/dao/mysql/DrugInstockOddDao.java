package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.DrugInstockOddPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugInstockOddPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugInstockOddDao {
    long countByExample(DrugInstockOddPoExample example);

    int deleteByExample(DrugInstockOddPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugInstockOddPo record);

    int insertSelective(DrugInstockOddPo record);

    List<DrugInstockOddPo> selectByExample(DrugInstockOddPoExample example);

    DrugInstockOddPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugInstockOddPo record, @Param("example") DrugInstockOddPoExample example);

    int updateByExample(@Param("record") DrugInstockOddPo record, @Param("example") DrugInstockOddPoExample example);

    int updateByPrimaryKeySelective(DrugInstockOddPo record);

    int updateByPrimaryKey(DrugInstockOddPo record);

    List<DrugInstockOddPo> selectByCon(DrugInstockOddPo po);
}