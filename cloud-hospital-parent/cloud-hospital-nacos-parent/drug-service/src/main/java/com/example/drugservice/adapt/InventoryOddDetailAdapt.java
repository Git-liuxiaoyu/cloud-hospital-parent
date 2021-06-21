package com.example.drugservice.adapt;

import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.outlet.dao.mysql.InventoryOddDao;
import com.example.drugservice.outlet.dao.mysql.InventoryOddDetailDao;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddPo;
import com.example.drugservice.service.addinventory.AddInventoryCommand;
import com.example.drugservice.service.addinventory.AddInventoryDetailCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class InventoryOddDetailAdapt {

    @Autowired
    private InventoryOddDetailDao inventoryOddDetailDao;
    //根据inventoryoddid查询详情
    public List<InventoryOddDetailVo> findByInventoryOddId(Long inventoryOddId){
        log.info("盘点id={}",inventoryOddId);
        List<InventoryOddDetailPo>poList =inventoryOddDetailDao.selectByInventoryOddId(inventoryOddId);

        //po转换vo
        List<InventoryOddDetailVo> voList = new ArrayList<>();
        for (InventoryOddDetailPo po : poList) {
            InventoryOddDetailVo vo = new InventoryOddDetailVo();
            vo.setDrugNo(po.getDrugno());
            vo.setDrugNum(po.getDrugnum());
            vo.setReason(po.getReason());
            vo.setDrugName(po.getDrugPo().getName());
            vo.setDrugSaleMoney(po.getDrugPo().getSaleprice());
            voList.add(vo);
        }
        return voList;

    }


}
