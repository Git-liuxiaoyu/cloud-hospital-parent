package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.DrugTypePo;
import com.example.drugservice.outlet.dao.mysql.po.DrugTypePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugTypeDao {
    long countByExample(DrugTypePoExample example);

    int deleteByExample(DrugTypePoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DrugTypePo record);

    int insertSelective(DrugTypePo record);

    List<DrugTypePo> selectByExample(DrugTypePoExample example);

    DrugTypePo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugTypePo record, @Param("example") DrugTypePoExample example);

    int updateByExample(@Param("record") DrugTypePo record, @Param("example") DrugTypePoExample example);

    int updateByPrimaryKeySelective(DrugTypePo record);

    int updateByPrimaryKey(DrugTypePo record);
}