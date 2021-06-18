package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.DrugPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugPoExample;
import java.util.List;

import lombok.ToString;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugDao {
    long countByExample(DrugPoExample example);

    int deleteByExample(DrugPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugPo record);

    int insertSelective(DrugPo record);

    List<DrugPo> selectByExample(DrugPoExample example);

    List<DrugPo> selectByCon(DrugPo drugPo);

    DrugPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugPo record, @Param("example") DrugPoExample example);

    int updateByExample(@Param("record") DrugPo record, @Param("example") DrugPoExample example);

    int updateByPrimaryKeySelective(DrugPo record);

    int updateByPrimaryKey(DrugPo record);

    DrugPo selectByNameAndByLocation(@Param("name")String name,@Param("location")String location);

    void updateByNo(@Param("stock") Integer stock,@Param("no") String no);

    DrugPo selectNo();

    void updateByNoReduce(@Param("no") String no, @Param("num") Integer num);
}