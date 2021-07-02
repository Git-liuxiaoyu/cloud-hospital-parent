package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.DrugOddPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugOddDao {



    long countByExample(DrugOddPoExample example);

    int deleteByExample(DrugOddPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugOddPo record);

    int insertSelective(DrugOddPo record);

    List<DrugOddPo> selectByExample(DrugOddPoExample example);

    DrugOddPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugOddPo record, @Param("example") DrugOddPoExample example);

    int updateByExample(@Param("record") DrugOddPo record, @Param("example") DrugOddPoExample example);

    int updateByPrimaryKeySelective(DrugOddPo record);

    int updateByPrimaryKey(DrugOddPo record);

    List<DrugOddPo> selectByCon(DrugOddPo po) ;

    DrugOddPo selectByNo(String no);

    DrugOddPo selectByNoAndStatus( String no);
}