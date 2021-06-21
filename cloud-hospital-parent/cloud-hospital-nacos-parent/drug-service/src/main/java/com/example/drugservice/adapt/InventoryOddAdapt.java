package com.example.drugservice.adapt;

import com.example.drugservice.adapt.converter.DrugOddVoConverter;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.outlet.dao.mysql.DrugDao;
import com.example.drugservice.outlet.dao.mysql.DrugOddDao;
import com.example.drugservice.outlet.dao.mysql.InventoryOddDao;
import com.example.drugservice.outlet.dao.mysql.InventoryOddDetailDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddPo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.InventoryOddPo;
import com.example.drugservice.service.addinventory.AddInventoryCommand;
import com.example.drugservice.service.addinventory.AddInventoryDetailCommand;
import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddCommand;
import com.example.drugservice.service.update.UpdateDrugOddCommand;
import com.example.drugservice.service.update.UpdateInventoryOddCommand;
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
public class InventoryOddAdapt {
    @Autowired
    private InventoryOddDao inventoryOddDao;

    @Autowired
    private InventoryOddDetailDao inventoryOddDetailDao;

    @Autowired
    private DrugDao drugDao;



    //条件查询集合
    public List<InventoryOddVo> findDrugListByExample(ExampleQueryInventoryOddCommand command){

        InventoryOddPo po = new InventoryOddPo();
        //command转换为po
        BeanUtils.copyProperties(command,po);

        List<InventoryOddPo> poList = inventoryOddDao.selectByCon(po);

        //新建一个vo集合
        List<InventoryOddVo> voList = new ArrayList<>();
        for (InventoryOddPo po1 : poList) {
            InventoryOddVo vo =new InventoryOddVo();
            //po转换为vo
            BeanUtils.copyProperties(po1,vo);
            voList.add(vo);
        }

        return voList;
    }

    //添加盘点单  和盘点单详情
    public void addInventoryOdd(AddInventoryCommand command){
        //先添加盘点单 回填id
        InventoryOddPo inventoryOddPo = new InventoryOddPo();
        inventoryOddPo.setInventoryperson(command.getName());
        inventoryOddPo.setStatus("0");
        inventoryOddPo.setCreatetime(new Date());
        //生成编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        inventoryOddPo.setNo(format+ (long) (Math.random() * 1000000));
        inventoryOddDao.insert(inventoryOddPo);

        //回填药品单id
        Long inventoryOddId = inventoryOddPo.getId();

        //传过来的详情集合
        List<AddInventoryDetailCommand> detailList = command.getPurPeoList();
        for (AddInventoryDetailCommand command1 : detailList) {
            //添加盘点单详情
            InventoryOddDetailPo inventoryOddDetailPo = new InventoryOddDetailPo();
            inventoryOddDetailPo.setDrugnum(command1.getLossdrugnum());
            inventoryOddDetailPo.setReason(command1.getLossReason());
            inventoryOddDetailPo.setDrugno(command1.getLossdrugno());
            inventoryOddDetailPo.setInventoryOddId(inventoryOddId);
            inventoryOddDetailDao.insert(inventoryOddDetailPo);
        }



    }

    //修改状态
    public void updateInventoryById(UpdateInventoryOddCommand command){
        InventoryOddPo po=new InventoryOddPo();
        po.setId(command.getId());
        po.setStatus("1");

        //drugOddDao.updateByPrimaryKey(po);
        //上面是普通修改   下面是动态修改
        inventoryOddDao.updateByPrimaryKeySelective(po);

        //修改状态后 减药品单的库存
        log.info("command为{}",command);
        //根据盘点id 查询 详情 拿到损耗药品的信息  然后在药品单减库存
        List<InventoryOddDetailPo> poList = inventoryOddDetailDao.selectByInventoryOddId(command.getId());

        for (InventoryOddDetailPo detailPo : poList) {
            //减库存
            drugDao.updateByNoReduce(detailPo.getDrugno(),detailPo.getDrugnum());
        }



    }


}
