package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.InventoryOddPo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryOddDao {
    long countByExample(InventoryOddPoExample example);

    int deleteByExample(InventoryOddPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InventoryOddPo record);

    int insertSelective(InventoryOddPo record);

    List<InventoryOddPo> selectByExample(InventoryOddPoExample example);

    InventoryOddPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InventoryOddPo record, @Param("example") InventoryOddPoExample example);

    int updateByExample(@Param("record") InventoryOddPo record, @Param("example") InventoryOddPoExample example);

    int updateByPrimaryKeySelective(InventoryOddPo record);

    int updateByPrimaryKey(InventoryOddPo record);

    List<InventoryOddPo> selectByCon(InventoryOddPo po);

}