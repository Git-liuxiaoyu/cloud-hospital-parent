package com.example.drugservice.adapt;

import com.example.drugservice.inlet.web.vo.DrugInstockOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.outlet.dao.es.DrugInstockOddEsDao;
import com.example.drugservice.outlet.dao.mysql.*;
import com.example.drugservice.outlet.dao.mysql.po.*;
import com.example.drugservice.service.addinstockodd.AddInstockOddCommand;
import com.example.drugservice.service.addinstockodddetail.AddInstockOddDetailCommand;
import com.example.drugservice.service.addinventory.AddInventoryCommand;
import com.example.drugservice.service.addinventory.AddInventoryDetailCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddCommand;
import com.example.drugservice.service.queryinstockodd.ExampleQueryDrugInstockOddCommand;
import com.example.drugservice.service.update.UpdateDrugInstockOddCommand;
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
public class DrugInstockOddAdapt {
    @Autowired
    private DrugInstockOddDao drugInstockOddDao;

    @Autowired
    private DrugInstockoddDetailDao drugInstockoddDetailDao;

    @Autowired
    private DrugDao drugDao;

    @Autowired
    private DrugInstockOddEsDao drugInstockOddEsDao;



    //条件查询集合
    public List<DrugInstockOddVo> findByExample(ExampleQueryDrugInstockOddCommand command){
        DrugInstockOddPo po = new DrugInstockOddPo();
        //command转换为po
        BeanUtils.copyProperties(command,po);

        List<DrugInstockOddPo> poList = drugInstockOddDao.selectByCon(po);

        //新建一个vo集合
        List<DrugInstockOddVo> voList = new ArrayList<>();
        for (DrugInstockOddPo po1 : poList) {
            DrugInstockOddVo vo =new DrugInstockOddVo();
            //po转换为vo
            BeanUtils.copyProperties(po1,vo);
            voList.add(vo);
        }
        return voList;
    }

    //添加进货单  和进货单详情
    public void addInstockOddAndInstockDetail(AddInstockOddCommand command){
        //生成编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());

        //先添加盘点单 回填id
        DrugInstockOddPo po = new DrugInstockOddPo();
        po.setInstockperson(command.getInStockPerson());
        po.setCreatetime(new Date());
        po.setNo(format+ (long) (Math.random() * 1000000));
        po.setStatus("0");
        drugInstockOddDao.insert(po);

        //回填进货单id   把进货单id存入进货详情
        Long inventoryOddId = po.getId();

        List<AddInstockOddDetailCommand> detailList = command.getPurPeoList();
        for (AddInstockOddDetailCommand command1 : detailList) {
            DrugInstockoddDetailPo po1 = new DrugInstockoddDetailPo();
            po1.setDrugcostprice(command1.getCostprice());
            po1.setDrugnum(command1.getNum());
            po1.setDrugexpirationtime(command1.getExpirationtime());
            po1.setDrugname(command1.getName());
            po1.setDruglocation(command1.getLocation());
            po1.setDrugproductiontime(command1.getProductiontime());
            po1.setDrugsaleprice(command1.getSaleprice());
            po1.setDrugtypeid(command1.getTypeId());
            po1.setDrugcostprice(command1.getCostprice());
            po1.setInstockoddid(inventoryOddId);
            drugInstockoddDetailDao.insert(po1);
        }

    }

    //修改状态  修改进货单状态 并且把进货单药品 添加到药品表里
    public void updateDrugInstockOddById(UpdateDrugInstockOddCommand command){
        DrugInstockOddPo po=new DrugInstockOddPo();
        po.setId(command.getId());
        po.setStatus("1");

        //动态修改
        drugInstockOddDao.updateByPrimaryKeySelective(po);

        //根据进货单id 查询详情
        List<DrugInstockoddDetailPo> poList = drugInstockoddDetailDao.selectByInstockOddId(command.getId());
        log.info("poList为{}",poList);

        for (DrugInstockoddDetailPo detailPo : poList) {
            //根据进货单的药品名和生产地判断是否存在于药品表
            DrugPo drugPo = drugDao.selectByNameAndByLocation(detailPo.getDrugname(), detailPo.getDruglocation());
            if (drugPo==null){
                log.info("该药不存在 正在新增");
                //如果不存在 就新增
                DrugPo drugPo2 = new DrugPo();
                drugPo2.setStock(detailPo.getDrugnum());
                drugPo2.setTypeid(detailPo.getDrugtypeid());
                drugPo2.setLocation(detailPo.getDruglocation());
                drugPo2.setName(detailPo.getDrugname());
                drugPo2.setCostprice(detailPo.getDrugcostprice());
                drugPo2.setSaleprice(detailPo.getDrugsaleprice());
                drugPo2.setProductiontime(detailPo.getDrugproductiontime());
                drugPo2.setExpirationtime(detailPo.getDrugexpirationtime());
                drugPo2.setStatus("1");
                //生产编号
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String format = simpleDateFormat.format(new Date());
                drugPo2.setNo(format+ (long) (Math.random() * 1000000));

                drugDao.insert(drugPo2);
            }else {
                log.info("该药存在 正在加库存");
                //存在就 加库存
                drugDao.updateByNo(detailPo.getDrugnum(),drugPo.getNo());
            }

        }
    }


}
