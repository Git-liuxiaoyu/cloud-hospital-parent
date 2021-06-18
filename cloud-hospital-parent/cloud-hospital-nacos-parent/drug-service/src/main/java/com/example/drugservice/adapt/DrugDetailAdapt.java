package com.example.drugservice.adapt;

import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugTypeVo;
import com.example.drugservice.outlet.dao.mysql.DrugOddDetailDao;
import com.example.drugservice.outlet.dao.mysql.DrugTypeDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddDetailPoExample;
import com.example.drugservice.outlet.dao.mysql.po.DrugTypePo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugDetailAdapt {
    @Autowired
    private DrugOddDetailDao drugOddDetailDao;

    //根据drugoddid查询列表
    public List<DrugOddDetailVo> findByDrugOddId(Long drugOddId){
        List<DrugOddDetailPo> drugOddDetailPos = drugOddDetailDao.selectByDrugoddId(drugOddId);

        System.out.println(drugOddDetailPos);
        List<DrugOddDetailVo> voList = new ArrayList<>();

        for (DrugOddDetailPo po : drugOddDetailPos) {
            DrugOddDetailVo vo = new DrugOddDetailVo();
            vo.setDrugNo(po.getDrugPo().getNo());
            vo.setDrugName(po.getDrugPo().getName());
            vo.setSaleMoney(po.getDrugPo().getSaleprice());
            BeanUtils.copyProperties(po,vo);
            voList.add(vo);
        }
        return voList;
        //调用dao
    }




}
