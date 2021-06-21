package com.example.drugservice.adapt;

import com.example.drugservice.inlet.web.vo.DrugInstockOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.outlet.dao.mysql.DrugInstockoddDetailDao;
import com.example.drugservice.outlet.dao.mysql.InventoryOddDetailDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugInstockoddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddDetailPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DrugInstockOddDetailAdapt {

    @Autowired
    private DrugInstockoddDetailDao drugInstockoddDetailDao;
    //根据inventoryoddid查询详情
    public List<DrugInstockOddDetailVo> findByInstockOddId(Long instockOddId){
        List<DrugInstockoddDetailPo> poList =drugInstockoddDetailDao.selectByInstockOddId(instockOddId);

        //po转换vo
        List<DrugInstockOddDetailVo> voList = new ArrayList<>();
        for (DrugInstockoddDetailPo po : poList) {
            DrugInstockOddDetailVo vo = new DrugInstockOddDetailVo();
            vo.setTypename(po.getDrugType().getDrugtype());
            BeanUtils.copyProperties(po,vo);
            voList.add(vo);
        }
        return voList;

    }


}
