package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddDetailPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryOddDetailDao {
    long countByExample(InventoryOddDetailPoExample example);

    int deleteByExample(InventoryOddDetailPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InventoryOddDetailPo record);

    int insertSelective(InventoryOddDetailPo record);

    List<InventoryOddDetailPo> selectByExample(InventoryOddDetailPoExample example);

    InventoryOddDetailPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InventoryOddDetailPo record, @Param("example") InventoryOddDetailPoExample example);

    int updateByExample(@Param("record") InventoryOddDetailPo record, @Param("example") InventoryOddDetailPoExample example);

    int updateByPrimaryKeySelective(InventoryOddDetailPo record);

    int updateByPrimaryKey(InventoryOddDetailPo record);

    List<InventoryOddDetailPo> selectByInventoryOddId(Long inventoryOddId);
}