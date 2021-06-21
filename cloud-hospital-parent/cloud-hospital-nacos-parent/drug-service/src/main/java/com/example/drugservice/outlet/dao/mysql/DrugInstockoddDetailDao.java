package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.DrugInstockoddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugInstockoddDetailPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugInstockoddDetailDao {
    long countByExample(DrugInstockoddDetailPoExample example);

    int deleteByExample(DrugInstockoddDetailPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugInstockoddDetailPo record);

    int insertSelective(DrugInstockoddDetailPo record);

    List<DrugInstockoddDetailPo> selectByExample(DrugInstockoddDetailPoExample example);

    DrugInstockoddDetailPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugInstockoddDetailPo record, @Param("example") DrugInstockoddDetailPoExample example);

    int updateByExample(@Param("record") DrugInstockoddDetailPo record, @Param("example") DrugInstockoddDetailPoExample example);

    int updateByPrimaryKeySelective(DrugInstockoddDetailPo record);

    int updateByPrimaryKey(DrugInstockoddDetailPo record);

    List<DrugInstockoddDetailPo> selectByInstockOddId(Long instockOddId);
}