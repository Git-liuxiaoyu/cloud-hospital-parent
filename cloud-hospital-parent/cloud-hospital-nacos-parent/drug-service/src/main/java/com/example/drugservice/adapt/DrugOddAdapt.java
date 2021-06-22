package com.example.drugservice.adapt;

import com.example.drugservice.adapt.converter.DrugOddVoConverter;
import com.example.drugservice.adapt.converter.DrugVoConverter;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.mysql.DrugDao;
import com.example.drugservice.outlet.dao.mysql.DrugOddDao;
import com.example.drugservice.outlet.dao.mysql.DrugTypeDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;
import com.example.drugservice.service.add.AddDrugOddCommand;
import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.example.drugservice.service.update.UpdateDrugOddCommand;
import com.example.drugservice.util.NoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DrugOddAdapt {
    @Autowired
    private DrugOddDao drugOddDao;

    @Autowired
    private DrugOddVoConverter converter;

    //条件查询集合
    public List<DrugOddVo> findDrugListByExample( ExampleQueryDrugOddCommand command){

        DrugOddPo  po = new DrugOddPo();
        //command转换为po
        BeanUtils.copyProperties(command,po);
        List<DrugOddPo> drugOddPos = drugOddDao.selectByCon(po);

        //新建一个vo集合
        List<DrugOddVo> voList = new ArrayList<>();
        for (DrugOddPo po1 : drugOddPos) {
            DrugOddVo vo = new DrugOddVo();
            //po转换为vo
            BeanUtils.copyProperties(po1,vo);
            voList.add(vo);
        }

        return voList;
    }

    //修改药单状态
    public void updateDrugById(UpdateDrugOddCommand command){
        DrugOddPo po = new DrugOddPo();
        po.setId(command.getId());
        po.setStatus("2");

        //drugOddDao.updateByPrimaryKey(po);
        //上面是普通修改   下面是动态修改
        drugOddDao.updateByPrimaryKeySelective(po);
    }

    //添加药品表单
    public Long addDrugOdd(AddDrugOddCommand command){
        DrugOddPo po  = new DrugOddPo();
        po.setNo(NoUtils.getNoUtils());
        po.setCreatetime(new Date());
        po.setDoctorid(command.getDoctorid());
        po.setPatientid(command.getDoctorid());
        //未支付状态
        po.setStatus("0");
        drugOddDao.insert(po);
        //主键回填id
        Long id = po.getId();
        return id;
    }

    //根据编号查询
    public DrugOddVo getByNo(String no){
      DrugOddPo po=  drugOddDao.selectByNo(no);
      DrugOddVo vo = new DrugOddVo();
      BeanUtils.copyProperties(po,vo);
      return vo;
    }


}
