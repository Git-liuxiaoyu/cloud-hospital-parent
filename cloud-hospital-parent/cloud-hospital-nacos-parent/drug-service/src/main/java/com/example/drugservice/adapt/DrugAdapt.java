package com.example.drugservice.adapt;

import com.example.drugservice.adapt.converter.DrugVoConverter;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.mysql.DrugDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;

import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugAdapt {
    @Autowired
    private DrugDao drugDao;

    @Autowired
    private DrugVoConverter converter;

//    @Autowired
//    private DrugRedisDao redisDao;



    //动态查询 分页列表
    public List<DrugVo> findDrugListByExample(ExampleQueryDrugCommand command){
        //先查redis
//        redisDao.findAllByNameAndNoAndLocation(command.getName(),
//                                                command.getNo(),
//                                                command.getLocation(),
//                                                command.getTypeId())
//                                                                        ;

        DrugPo  po = new DrugPo();
        BeanUtils.copyProperties(command,po);
        List<DrugPo> drugPos = drugDao.selectByCon(po);
        List<DrugVo> drugVos = converter.convert(drugPos);

        return drugVos;
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
    }


    //增加药品库存
    public void upDateDrug(InStockDrugCommand command){
        System.out.println("nono"+command.getNo());

        drugDao.updateByNo(command.getNum(),command.getNo());

    }

    //减少药品库存
    public void updateDrugReduce(String no,Integer num){

        drugDao.updateByNoReduce(no,num);
    }
}
