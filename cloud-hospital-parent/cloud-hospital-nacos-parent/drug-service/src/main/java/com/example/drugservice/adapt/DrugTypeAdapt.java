package com.example.drugservice.adapt;

import com.example.drugservice.inlet.web.vo.DrugTypeVo;
import com.example.drugservice.outlet.dao.mysql.DrugTypeDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugTypePo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugTypeAdapt {
    @Autowired
    private DrugTypeDao drugTypeDao;

    //查询所有
    public List<DrugTypeVo> findList(){
        List<DrugTypePo> drugTypePos = drugTypeDao.selectByExample(null);
        List<DrugTypeVo> drugTypeVos = new ArrayList<>();

        for (DrugTypePo drugTypePo : drugTypePos) {
            DrugTypeVo vo = new DrugTypeVo();
            vo.setTypeId(drugTypePo.getId());
            BeanUtils.copyProperties(drugTypePo,vo);
            drugTypeVos.add(vo);
        }
        return drugTypeVos;
    }

}
