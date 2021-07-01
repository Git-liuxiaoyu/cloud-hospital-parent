package com.example.takenumberservice.outlet.dao.mysql;

import com.example.takenumberservice.outlet.dao.mysql.pojo.MassagePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 消息表dao
 */
@Repository
public interface MassageDao {

    /**
     * 存入消息表
     * @param msgpo
     * @return
     */
    int addMassage(MassagePo msgpo);

    int updateMessage(MassagePo msgpo);

    int updateMessagecont(MassagePo msgpo);

    /**
     * 根据id查询消息
     * @param msgpo
     * @return
     */
    MassagePo findbyId(MassagePo msgpo);

    /**
     * 查询状态为发送失败的数据  （2）
     * @return
     */
    List<MassagePo> findbystatus();


}
