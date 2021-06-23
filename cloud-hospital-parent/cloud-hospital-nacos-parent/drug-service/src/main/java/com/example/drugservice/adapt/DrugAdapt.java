package com.example.drugservice.adapt;

import com.example.drugservice.adapt.converter.DrugVoConverter;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.es.DrugEsDao;
import com.example.drugservice.outlet.dao.es.po.DrugEsPo;
import com.example.drugservice.outlet.dao.mysql.DrugDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;

import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DrugAdapt {
    @Autowired
    private DrugDao drugDao;

    @Autowired
    private DrugVoConverter converter;

    @Autowired
    private DrugEsDao drugEsDao;

    //动态查询 分页列表
    public List<DrugVo> findDrugListByExample(ExampleQueryDrugCommand command){
        //查es
        List<DrugEsPo> poList =new ArrayList<>();
        if (command.getNo()!=null){
            poList=drugEsDao.findAllByNo(command.getNo());
        }else if (command.getName()!=null){
            poList= drugEsDao.findAllByName(command.getName());
        }else {
           poList= drugEsDao.findAll();
        }
        //es po 转换为vo
        List<DrugVo> vos = converter.convert2(poList);

//        if (poList.size()==0){
//            log.info("走mysql 查询列表");
//
//            DrugPo  po = new DrugPo();
//            BeanUtils.copyProperties(command,po);
//            List<DrugPo> drugPos = drugDao.selectByCon(po);
//            List<DrugVo> drugVos = converter.convert(drugPos);
//
//            //mysql数据转存到es
//            for (DrugPo drugPo : drugPos) {
//                DrugEsPo po1 = new DrugEsPo();
//                po1.setTypeName(drugPo.getDrugtype());
//                po1.setStock(drugPo.getStock());
//                BeanUtils.copyProperties(drugPo,po1);
//                drugEsDao.save(po1);
//            }
//            return drugVos;
//        }
        log.info("走es 查询列表");
        return vos;
    }


    //根据药品名和生产地查询
    public InStockDrugCommand getDrugByNameAndLocation(String name,String location){
        DrugPo po = new DrugPo();
        po.setName(name);
        po.setLocation(location);
        DrugPo po1 = drugDao.selectByNameAndByLocation(name, location);

        InStockDrugCommand command = new InStockDrugCommand();
        System.out.println(po1);
        if (po1==null){
            //返回一个空
            return null;
        }
        BeanUtils.copyProperties(po1,command);
        return command;
    }

    //添加药品
    public void AddDrug(InStockDrugCommand command){
        //查询最后一个编号然后+1
        DrugPo po1 = drugDao.selectNo();
        int no = Integer.parseInt(po1.getNo());
        System.out.println(no);

        DrugPo po = new DrugPo();
        po.setNo(no+1+"");
        po.setTypeid(command.getTypeId());
        po.setStock(command.getNum());

        BeanUtils.copyProperties(command,po);
        drugDao.insert(po);

        //同时存入es
        DrugEsPo drugEsPo = new DrugEsPo();
        BeanUtils.copyProperties(po,drugEsPo);
        drugEsDao.save(drugEsPo);

    }


    //增加药品库存
    public void upDateDrug(InStockDrugCommand command){
        System.out.println("nono"+command.getNo());

        drugDao.updateByNo(command.getNum(),command.getNo());

        //查出es对象 然后修改
        DrugEsPo esPo = drugEsDao.getAllByNo(command.getNo());
        esPo.setStock(esPo.getStock()+command.getNum());
        drugEsDao.save(esPo);



    }

    //减少药品库存
    public void updateDrugReduce(String no,Integer num){

        drugDao.updateByNoReduce(no,num);

        //查出es对象 然后修改
        DrugEsPo esPo = drugEsDao.getAllByNo(no);
        esPo.setStock(esPo.getStock()-num);
        drugEsDao.save(esPo);
    }
}
